package org.nofdev.transaction

import org.nofdev.transaction.domain.Transaction
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Qiang on 4/28/15.
 */
@Service
class TransactionService {

    /**
     * 创建一个交易
     * @param transaction
     * @return
     */
    @Transactional
    TransactionDTO create(TransactionDTO transaction) {
        use(TransactionDTOConverter, TransactionConverter) {
            if (!transaction.status) {
                transaction.status = TransactionStatus.PAYING
            }
            transaction.toEntity().save(flush: true, failOnError: true)?.toDTO()
        }
    }

    List<TransactionDTO> list(TransactionCriteria criteria) {
        use(TransactionConverter) {
            Transaction.where {
                if (criteria?.statusEq) {
                    status == criteria.statusEq
                }
            }.list()?.collect {
                it.toDTO()
            }
        }
    }
}
