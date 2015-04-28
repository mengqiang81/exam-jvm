package org.nofdev.transaction

import org.nofdev.transaction.domain.Transaction

/**
 * Created by Qiang on 4/28/15.
 * 交易 domain 转化为 dto 的转换器
 */
@Category(Transaction)
class TransactionConverter {
    TransactionDTO toDTO(){
        new TransactionDTO(
                id:this.id,
                status: this.status,
                type: this.type,
                amount:this.amount,
                currency: this.currency,
                dateCreated:this.dateCreated
        )
    }
}
