//package com.nbva.product.common.dto;
//
//import java.util.function.Function;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.domain.Page;
//
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class PageResponse<T> {
//    private int pageNumber;
//    private int pageSize;
//    private long totalElements;
//    private int totalPages;
//    private List<T> data;
//
//    public <U> PageResponse(Page<U> page, Function<U, T> mapper) {
//        this.pageNumber = page.getNumber();
//        this.pageSize = page.getSize();
//        this.totalElements = page.getTotalElements();
//        this.totalPages = page.getTotalPages();
//        this.data = page.getContent().stream().map(mapper).toList();
//    }
//}
