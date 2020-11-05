package com.loylty.retail.customer.engine.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.loylty.retail.customer.engine.entities.CustomerLedger;
import com.loylty.retail.customer.engine.service.CustomerLedgerRepository;

//@Repository
//public class CustomerLedgerRepositoryImpl implements CustomerLedgerRepository {
//
//	@Override
//	public List<CustomerLedger> findByCustomerId(String customerId, EntityManager entityManger) {
//		String sql = "SELECT cl FROM CustomerLedger cl WHERE cl.customerId = :customerId";
//		TypedQuery<CustomerLedger> query = entityManger.createQuery(sql, CustomerLedger.class).setParameter("customerId", customerId);
//		return query.getResultList();
//	}
//
//	@Override
//	public void save(CustomerLedger customerLedger, EntityManager entityManger) {
//		entityManger.getTransaction().begin();
//		entityManger.persist(customerLedger);
//		entityManger.getTransaction().commit();
//	}
//}
