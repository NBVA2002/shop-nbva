package com.nbva.common.dto.request;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageRequest {
    protected int pageNumber = 0;
    protected int pageSize = 10;
    protected Sort sort;

    public Pageable toPageable() {
        if (sort != null) {
            return org.springframework.data.domain.PageRequest.of(pageNumber, pageSize, sort);
        } else {
            return org.springframework.data.domain.PageRequest.of(pageNumber, pageSize);
        }
    }
}
