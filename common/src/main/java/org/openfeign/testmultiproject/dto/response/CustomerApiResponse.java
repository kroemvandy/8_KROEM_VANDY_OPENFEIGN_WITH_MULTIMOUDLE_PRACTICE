package org.openfeign.testmultiproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerApiResponse {
    private Long customerId;
    private String CustomerName;
    private String CustomerEmail;
}
