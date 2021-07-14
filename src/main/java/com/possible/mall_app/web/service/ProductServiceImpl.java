package com.possible.mall_app.web.service;

import com.possible.mall_app.domain.Product;
import com.possible.mall_app.exceptions.NotFoundException;
import com.possible.mall_app.repository.ProductRepository;
import com.possible.mall_app.web.Model.ProductDto;
import com.possible.mall_app.web.Model.ProductTypeEnum;
import com.possible.mall_app.web.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductById(UUID product_id) {
        return productMapper.productToProductDto(
                productRepository.findById(product_id)
                        .orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return productMapper.productToProductDto(
                productRepository.save(productMapper.productDtoToProduct(productDto))
        );
    }

    @Override
    public ProductDto updateProduct(UUID product_id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(product_id).orElseThrow(NotFoundException::new);

        existingProduct.setProductName(productDto.getProductName());
        existingProduct.setProductType(productDto.getProductType().name());
        existingProduct.setProductPrice(productDto.getPrice());
        existingProduct.setUpc(productDto.getUpc());

        return productMapper.productToProductDto(productRepository.save(existingProduct));

    }

    @Override
    public void deleteById(UUID product_id) {
        log.debug("Product deleted");
    }
}
