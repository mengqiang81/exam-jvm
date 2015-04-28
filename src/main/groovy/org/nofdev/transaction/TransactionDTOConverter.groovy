package org.nofdev.transaction

import org.nofdev.transaction.domain.Customer
import org.nofdev.transaction.domain.Transaction
/**
 * Created by Qiang on 4/28/15.
 */
@Category(TransactionDTO)
class TransactionDTOConverter {
    Transaction toEntity(){
        new Transaction(
                status:this.status,
                type:this.type,
                amount:this.amount,
                currency: this.currency,
                customer:Customer.get(this.customer.id)//TODO 这个地方需要更加严格的验证逻辑
        )
    }
}
