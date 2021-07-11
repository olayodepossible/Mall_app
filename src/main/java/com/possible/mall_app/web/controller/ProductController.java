package com.possible.mall_app.web.controller;

import com.possible.mall_app.web.Model.ProductDto;
import com.possible.mall_app.web.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable UUID product_id){

        return new ResponseEntity<ProductDto>(productService.getProductById(product_id), HttpStatus.OK);
    }
}
