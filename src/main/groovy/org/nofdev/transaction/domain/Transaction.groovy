package org.nofdev.transaction.domain

import grails.persistence.Entity

/**
 * Created by Qiang on 4/28/15.
 */
@Entity
class Transaction {
    String id

    /**
     * 交易状态
     */
    String status
    /**
     * 交易类型
     */
    String type
    /**
     * 交易金额
     */
    BigDecimal amount
    /**
     * 币种
     */
    String currency
    /**
     * 客户信息
     */
    Customer customer

    Date dateCreated
    Date lastUpdated

    static embedded = ['customer']

    static constraints = {

    }

    static mapping = {
        id generator: 'uuid2'
    }
}
