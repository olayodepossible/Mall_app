package com.possible.mall_app.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.possible.mall_app.web.Model.ProductDto;
import com.possible.mall_app.web.Model.ProductTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    ProductDto getValidProductDto(){
        return ProductDto.builder()
                .productName("Redmi")
                .price(new BigDecimal("120"))
                .upc(1L)
                .productType(ProductTypeEnum.PHONE)
                .build();
    }

    @Test
    void getProduct() throws Exception {
        mockMvc.perform(get("api/v1/product"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        ProductDto productDto = getValidProductDto();
        String productToJson = mapper.writeValueAsString(productDto);

        mockMvc.perform(post("api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productToJson)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateProductById() throws Exception {
        ProductDto productDto = getValidProductDto();
        String productToJson = mapper.writeValueAsString(productDto);

        mockMvc.perform(put("api/v1/product"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(productToJson)
        ).andExpect(status().isCreated());


    }

    @Test
    void deleteProduct() {
    }
}