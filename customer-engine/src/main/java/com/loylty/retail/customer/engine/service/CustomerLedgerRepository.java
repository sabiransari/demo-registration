package com.loylty.retail.customer.engine.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loylty.retail.customer.engine.entities.CustomerLedger;

@Repository
public interface CustomerLedgerRepository extends JpaRepository<CustomerLedger, Long>{
//	public List<CustomerLedger> findByCustomerId(String customerId, EntityManager entityManger);
//	public void save(CustomerLedger customerLedger, EntityManager entityManger);
	
	public List<CustomerLedger> findByCustomerId(String customerId);
}
