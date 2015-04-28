package org.nofdev.common

import grails.gorm.PagedResultList
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

/**
 * Created by Qiang on 3/6/15.
 */
@Category(PagedResultList)
class PagedResultListCategory {
    public <E> Page<E> asPage(Pageable paginator, Closure toDTO = null) {
        new PageImpl<E>(toDTO ? this.collect(toDTO) : this, paginator, this.getTotalCount())
    }
}
