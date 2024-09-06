package org.openfeign.testmultiproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductApiResponse<T> {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
}
