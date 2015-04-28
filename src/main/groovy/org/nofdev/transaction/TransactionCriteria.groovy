package org.nofdev.transaction

import javax.ws.rs.QueryParam

/**
 * Created by Qiang on 4/28/15.
 * 交易查询构造器
 */
class TransactionCriteria {
    /**
     * 交易状态，如果为空，则显示全部状态的交易
     */
    @QueryParam("status_eq")
    String statusEq
}
