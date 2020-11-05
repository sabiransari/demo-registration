package com.loylty.retail.customer.engine.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loylty.retail.customer.engine.entities.CustomerSummary;

public interface CustomerSummaryRepository extends MongoRepository<CustomerSummary, Long> {

}
