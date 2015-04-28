package org.nofdev.transaction

/**
 * Created by Qiang on 4/28/15.
 * 交易信息
 */
class TransactionDTO {
    String id
    /**
     * 交易状态
     */
    TransactionStatus status
    /**
     * 交易类型
     */
    TransactionType type
    /**
     * 交易金额
     */
    BigDecimal amount
    /**
     * 币种
     */
    PayCurrency currency
    /**
     * 客户信息
     */
    CustomerDTO customer
    /**
     * 交易创建时间
     */
    Date dateCreated
}
