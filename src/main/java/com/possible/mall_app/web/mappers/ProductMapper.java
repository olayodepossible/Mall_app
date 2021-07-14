package com.possible.mall_app.web.mappers;

import com.possible.mall_app.domain.Product;
import com.possible.mall_app.web.Model.ProductDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ProductMapper {

    Product  productDtoToProduct(ProductDto dto);
    ProductDto productToProductDto(Product product);
}
