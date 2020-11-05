package com.loylty.retail.customer.engine.model;

public class TransactionPayment {
	private String cardFirst6Digit;
	private String cardLast4Digit;
	private String paymentMode;
	public String getCardFirst6Digit() {
		return cardFirst6Digit;
	}
	public void setCardFirst6Digit(String cardFirst6Digit) {
		this.cardFirst6Digit = cardFirst6Digit;
	}
	public String getCardLast4Digit() {
		return cardLast4Digit;
	}
	public void setCardLast4Digit(String cardLast4Digit) {
		this.cardLast4Digit = cardLast4Digit;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
}
