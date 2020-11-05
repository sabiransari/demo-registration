package com.loylty.retail.customer.engine.model;

public class Transaction extends AbstractRequest {
	protected String customerId;
	protected String transactionId;
	protected String transactionDate;
	protected String transactionAmount;
	protected String taxAmount;
	protected String transactionType;
	private TransactionPayment transactionPayment;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public TransactionPayment getTransactionPayment() {
		return transactionPayment;
	}
	
	public void setTransactionPayment(TransactionPayment transactionPayment) {
		this.transactionPayment = transactionPayment;
	}
}
