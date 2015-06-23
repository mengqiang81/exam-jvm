package com.yintai.trx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yintai.trx.domain.Transaction;
import com.yintai.trx.service.TransactionService;
@Controller
public class TransactionController {
	
	@Autowired
    private TransactionService trxService;	
	
	@RequestMapping(value="/trx/addTransaction", method=RequestMethod.POST)
	@ResponseBody
	public Transaction addTransaction(Transaction trx) {
        Transaction transacton =trxService.addTransaction(trx);
		return transacton;
	}
	
	@RequestMapping(value="/trx/getTransactions", method=RequestMethod.GET)
	@ResponseBody
	public List<Transaction> getTransactions(int transactionStatus) {
        List<Transaction> transactions =trxService.getTransactions(transactionStatus);
		return transactions;
	}

}
