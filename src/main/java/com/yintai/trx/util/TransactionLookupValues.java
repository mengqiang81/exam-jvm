package com.yintai.trx.util;
public class TransactionLookupValues {
    
	//success:1  failed:2  pending:3
	public static final int TRANSACTION_STATUS_SUCCESS = 1;
    public static final int TRANSACTION_STATUS_FAILED = 2;
    public static final int TRANSACTION_STATUS_PENDING = 3;
    
    //all status:-1 payment:1 refund:2
    public static final int TRANSACTION_TYPE_ALL = -1;
    public static final int TRANSACTION_TYPE_PAYMENT = 1;
    public static final int TRANSACTION_TYPE_REFUND = 2;
    
    //dollar:1 rmb:2
    public static final int CURRENCY_TYPE_DOLLAR = 1;
    public static final int CURRENCY_TYPE_RMB = 2;
}
