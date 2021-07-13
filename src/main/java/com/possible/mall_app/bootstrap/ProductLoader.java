package com.possible.mall_app.bootstrap;

import com.possible.mall_app.domain.Product;
import com.possible.mall_app.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements CommandLineRunner {

    private ProductRepository productRepository;

    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProductObject();
    }

    private void loadProductObject() {
        if (productRepository.count() == 0){
            productRepository.save(Product.builder()
                    .productName("Vivo e2")
                    .productType("Phone")
                    .productPrice(new BigDecimal("125"))
                    .upc(2345678L)
                    .build());

            productRepository.save(Product.builder()
                    .productName("Redmi e2")
                    .productType("Phone")
                    .productPrice(new BigDecimal("125"))
                    .upc(12345678L)
                    .build());
        }
    }
}
