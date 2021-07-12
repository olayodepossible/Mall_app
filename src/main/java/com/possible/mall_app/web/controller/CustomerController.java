package com.possible.mall_app.web.controller;

import com.possible.mall_app.web.Model.CustomerDto;
import com.possible.mall_app.web.Model.ProductDto;
import com.possible.mall_app.web.service.CustomerService;
import com.possible.mall_app.web.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customer_id){
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customer_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer =  customerService.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer"+savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);


    }

    @PutMapping("/{customer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable UUID customer_id, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customer_id, customerDto);
    }

    @DeleteMapping("/{customer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customer_id){
        customerService.deleteById(customer_id);
    }
}
