package com.loylty.retail.customer.engine.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.loylty.retail.customer.engine.model.Transaction;
import com.loylty.retail.customer.engine.util.JsonUtil;

@Service
public class TestService {

	public Transaction getTransaction(String json) throws JsonMappingException, JsonProcessingException {
		Transaction transaction = JsonUtil.fromJson(json, Transaction.class);
		return transaction;
	}

}
