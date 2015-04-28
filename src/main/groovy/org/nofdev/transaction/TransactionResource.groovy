package org.nofdev.transaction

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Created by Qiang on 4/28/15.
 */
@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
class TransactionResource {
    @Autowired
    private TransactionService transactionService

    /**
     * 构造查询条件查询
     * @param criteria 请求方式为 ?status_eq=PAYING 这种
     * @return
     */
    @GET
    List<TransactionDTO> index(@BeanParam TransactionCriteria criteria) {
        transactionService.list(criteria)
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    TransactionDTO create(TransactionDTO transaction) {
        transactionService.create(transaction)
    }
}
