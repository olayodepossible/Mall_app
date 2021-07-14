package com.possible.mall_app.web.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductPageList extends PageImpl<ProductDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProductPageList(
            @JsonProperty("content") List<ProductDto> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalPage") int totalPage,
            @JsonProperty("last") boolean last,
            @JsonProperty("first") boolean first,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("sort")JsonNode sort,
            @JsonProperty("numberOfElement") int numberOfElement,
            @JsonProperty("pageable")JsonNode pageable,
            long total) {
        super(content, PageRequest.of(number, size), totalElements);
    }

    public ProductPageList(List<ProductDto> content) {
        super(content);
    }

    public ProductPageList(List<ProductDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
