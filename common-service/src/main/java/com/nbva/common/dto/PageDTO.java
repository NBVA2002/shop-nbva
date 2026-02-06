package com.nbva.common.dto;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO<T> {
    private int page;
    private int size;
    private long totalElement;
    private int totalPage;
    private List<T> data;

    public PageDTO(int page, int size, long totalElement, List<T> data) {
        this.page = page;
        this.size = size;
        this.totalElement = totalElement;
        this.totalPage = (int) Math.ceil((double) totalElement / size);
        this.data = data;
    }

    public <U> PageDTO(Page<U> page, Function<U, T> mapper) {
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElement = page.getTotalElements();
        this.totalPage = page.getTotalPages();
        this.data = page.getContent().stream().map(mapper).toList();
    }
}
