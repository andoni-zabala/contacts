package com.demo.contacts.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedResultsDto<TDto> {

    private List<TDto> results;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalResults;
}