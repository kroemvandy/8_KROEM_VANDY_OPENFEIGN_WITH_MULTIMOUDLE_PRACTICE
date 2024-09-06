package org.openfeign.testmultiproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderApiResponse<T> {
    private Long orderId;
    private CustomerApiResponse customerResponse;
    private List<ProductApiResponse> productResponses;
    private LocalDate orderDate = LocalDate.now();
}
