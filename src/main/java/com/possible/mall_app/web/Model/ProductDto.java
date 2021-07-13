package com.possible.mall_app.web.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    @Null
    private UUID id;

    @Null
    private Integer productVersion;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String productName;

    private ProductTypeEnum productType;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private BigDecimal price;
    private Integer quantity;

}
