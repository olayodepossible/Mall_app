package com.possible.mall_app.web.service;

import com.possible.mall_app.web.Model.CustomerDto;
import com.possible.mall_app.web.Model.ProductDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customer_id);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customer_id, CustomerDto customerDto);

    void deleteById(UUID customer_id);
}
