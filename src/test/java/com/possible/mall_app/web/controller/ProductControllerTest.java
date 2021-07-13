package com.possible.mall_app.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.possible.mall_app.web.Model.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void getProduct() throws Exception {
        mockMvc.perform(get("api/v1/product"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        ProductDto productDto = ProductDto.builder().build();
        String producttoToJson = mapper.writeValueAsString(productDto);

        mockMvc.perform(post("api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(producttoToJson)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}