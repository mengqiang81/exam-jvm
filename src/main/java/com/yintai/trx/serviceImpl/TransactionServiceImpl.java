package com.yintai.trx.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yintai.trx.datasource.TransactionStore;
import com.yintai.trx.domain.Transaction;
import com.yintai.trx.service.TransactionService;
import com.yintai.trx.util.TransactionUtil;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Override
	public Transaction addTransaction(Transaction trx) {
		trx.setTransactionId(TransactionStore.getNextId());
		trx.setCreateDate(TransactionUtil.getCurrentDatetime());
		
		return TransactionStore.addTransaction(trx);
	}
	
	@Override
	public List<Transaction> getTransactions(int transactionStatus) {
		List<Transaction> transactionList = TransactionStore.getTransactions(transactionStatus);

		return transactionList;
	}
}
