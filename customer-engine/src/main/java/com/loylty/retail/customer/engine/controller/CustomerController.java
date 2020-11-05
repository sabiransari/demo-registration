package com.loylty.retail.customer.engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loylty.retail.customer.engine.entities.CustomerLedger;
import com.loylty.retail.customer.engine.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired 
	private CustomerService customerService;

	@PostMapping("/group/{groupId}/customer")
	public ResponseEntity<CustomerLedger> registerCustomer(@RequestBody CustomerLedger customerLedger, 
			@PathVariable String groupId) {
		customerService.registerCustomer(groupId, customerLedger);
		return ResponseEntity.ok(customerLedger);
	}
	
	@GetMapping("/group/{groupId}/customer/{customerId}")
	public ResponseEntity<Object> getCustomer(@PathVariable String groupId, @PathVariable String customerId) {
		List<CustomerLedger> customers = customerService.getCustomer(groupId, customerId);
		return ResponseEntity.ok(customers.isEmpty() ? null : customers.get(0));
	}
}
