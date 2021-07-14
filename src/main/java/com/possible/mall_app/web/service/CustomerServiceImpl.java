package com.possible.mall_app.web.service;

import com.possible.mall_app.web.Model.CustomerDto;
import com.possible.mall_app.web.Model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID product_id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Tom Hill")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customer_id, CustomerDto customerDto) {
        log.debug("Product deleted");
    }

    @Override
    public void deleteById(UUID customer_id) {
        log.debug("Product deleted");
    }
}
