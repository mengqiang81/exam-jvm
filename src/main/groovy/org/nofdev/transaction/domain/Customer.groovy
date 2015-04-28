package org.nofdev.transaction.domain

import grails.persistence.Entity

/**
 * Created by Qiang on 4/28/15.
 * 客户
 */
@Entity
class Customer {
    String id
    String firstName
    String lastName

    static mapping = {
        id generator: 'uuid2'
    }
}
