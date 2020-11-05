package com.loylty.retail.customer.engine.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.loylty.retail.config.InjectDataSource;
import com.loylty.retail.customer.engine.entities.CustomerLedger;
import com.loylty.retail.customer.engine.entities.CustomerSummary;
import com.loylty.retail.task.processor.TaskProcessorContext;

@Service
@Validated
@InjectDataSource
public class CustomerService {
	@Autowired
	private GroupService groupService;
	@Autowired
	private CommunicationService communicationService;
	@Autowired
	private TaskProcessorContext taskProcessorContext;
	
	@Autowired
	private CustomerLedgerRepository customerLedgerRepository;
	@Autowired
	private CustomerSummaryRepository customerSummaryRepository;
	
	@Validated
	@Transactional
	public void registerCustomer(@NotNull String groupId, @Valid CustomerLedger customerLedger) {
		if (!groupService.isGroupExists(groupId)) {
			throw new RuntimeException("No such Group exists");
		}
		if (isCustomerExists(groupId, customerLedger.getCustomerId())) {
			throw new RuntimeException("Customer already exists");
		}
		communicationService.verifyOtp();
		taskProcessorContext.processConfiguredTasks(groupId);
		customerLedgerRepository.save(customerLedger);
		customerSummaryRepository.save(getCustomerSummary(customerLedger));
	}

	private CustomerSummary getCustomerSummary(@Valid CustomerLedger customerLedger) {
		CustomerSummary summary = new CustomerSummary();
		summary.setCustomerId(customerLedger.getCustomerId());
		summary.setFirstName(customerLedger.getFirstName());
		summary.setMobile(customerLedger.getMobile());
		return summary;
	}

	public boolean isCustomerExists(String groupId, String customerId) {
		return customerLedgerRepository.findByCustomerId(customerId).size() > 0;
	}

	@Validated
	public List<CustomerLedger> getCustomer(@NotBlank String groupId, @NotBlank String customerId) {
		return customerLedgerRepository.findByCustomerId(customerId);
	}
}
