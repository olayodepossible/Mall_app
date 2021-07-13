package com.possible.mall_app.repository;

import com.possible.mall_app.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {
}
