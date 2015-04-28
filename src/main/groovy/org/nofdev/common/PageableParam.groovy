package org.nofdev.common

import javax.ws.rs.DefaultValue
import javax.ws.rs.QueryParam

/**
 * Created by Qiang on 3/10/15.
 */
class PageableParam {
    @DefaultValue("1")
    @QueryParam("page")
    Integer page
    @DefaultValue("10")
    @QueryParam("per_page")
    Integer pageSize
}
