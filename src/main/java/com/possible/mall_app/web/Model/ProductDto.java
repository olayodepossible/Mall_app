package com.possible.mall_app.web.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private UUID id;
    private Integer productVersion;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String productName;
    private ProductTypeEnum productType;
    private Long upc;
    private BigDecimal price;
    private Integer quantity;

}
