package org.nofdev.transaction

/**
 * Created by Qiang on 4/28/15.
 * 交易状态
 */
public enum TransactionStatus {
    /**
     * 交易成功
     */
    SUCCESS,
    /**
     * 等待付款
     */
    PAYING,
    /**
     * 交易失败
     */
    FAILURE
}