package com.loylty.retail.customer.engine.controller;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loylty.retail.customer.engine.model.Transaction;
import com.loylty.retail.customer.engine.model.RequestSource;
import com.loylty.retail.customer.engine.service.TestService;
import com.loylty.retail.customer.engine.util.JsonUtil;

@RestController
@RequestMapping("/api")
public class TestController {
	@Autowired
	private TestService testService;

	@PostMapping("/transaction")
	public ResponseEntity<Transaction> getApiTransaction(@RequestBody Transaction transaction) throws JsonProcessingException {
		transaction.setRequestSource(RequestSource.API);
		Transaction txn = testService.getTransaction(JsonUtil.toJson(transaction));
		return ResponseEntity.ok(txn);
	}
}
