package com.yintai.trx.service;

import java.util.List;

import com.yintai.trx.domain.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction trx);
	
	public List<Transaction> getTransactions(int transactionStatus);
}


