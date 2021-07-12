package com.possible.mall_app.web.controller;

import com.possible.mall_app.web.Model.ProductDto;
import com.possible.mall_app.web.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable UUID product_id){
        return new ResponseEntity<ProductDto>(productService.getProductById(product_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){
       ProductDto savedProduct =  productService.saveProduct(productDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/product"+savedProduct.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);


    }

    @PutMapping("/{product_id}")
    public ResponseEntity updateProduct(@PathVariable UUID product_id, @RequestBody ProductDto productDto){
        productService.updateProduct(product_id, productDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{product_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable UUID product_id){
        productService.deleteById(product_id);
    }
}
