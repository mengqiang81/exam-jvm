package com.yintai.trx.domain;

import java.util.Date;

public class Transaction {

	private int transactionId;
	private Date createDate;
	private int transactionStatus;
	private int transactionType;
	private float transactionAmount;
	private int currencyType;
	private Client client;
	
	
	public Transaction() {
		super();
	}
	public Transaction(int transactionId, Date createDate,
			int transactionStatus, int transactionType,
			float transactionAmount, int currencyType, Client client) {
		super();
		this.transactionId = transactionId;
		this.createDate = createDate;
		this.transactionStatus = transactionStatus;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.currencyType = currencyType;
		this.client = client;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(int currencyType) {
		this.currencyType = currencyType;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
