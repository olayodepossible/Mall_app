package com.possible.mall_app.web.service;

import com.possible.mall_app.web.Model.ProductDto;

import java.util.UUID;

public interface ProductService {
    ProductDto getProductById(UUID product_id);
}
