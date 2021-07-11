package com.possible.mall_app.web.service;

import com.possible.mall_app.web.Model.ProductDto;

import java.util.UUID;

public class ProductServiceImpl implements ProductService{
    @Override
    public ProductDto getProductById(UUID product_id) {
        return ProductDto.builder()
                .id(UUID.randomUUID())
                .productName("Vivi e2c")
                .productType("Mobile Phone")
                .build();
    }
}
