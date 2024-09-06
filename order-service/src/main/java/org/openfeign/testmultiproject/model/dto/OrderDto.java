package org.openfeign.testmultiproject.model.dto;

import jakarta.persistence.ElementCollection;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long customerId;
    @ElementCollection
    private List<Long> productIds;
}
