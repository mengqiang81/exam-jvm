package com.yintai.trx.datasource;

import java.util.ArrayList;
import java.util.List;

import com.yintai.trx.domain.Transaction;
import com.yintai.trx.util.TransactionLookupValues;

public class TransactionStore {
    
	private static List<Transaction> transactions = new ArrayList<Transaction>();
    private static int NextId;
	
	public static Transaction addTransaction(Transaction trx){
		if(transactions.add(trx)){
			return trx;
		}
		else{
			return null;
		}
	}
	
	public static List<Transaction> getTransactions(int transactionStatus){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		if(transactionStatus == TransactionLookupValues.TRANSACTION_TYPE_ALL) {
			return transactions;
		}
		else{
		for(Transaction transaction : transactions) {
			if(transaction.getTransactionStatus() == transactionStatus) {
				transactionList.add(transaction);
			}
		}
		}
		return transactionList;
	}
	
	public static int getNextId() {
		return ++NextId;
	}
	
}
