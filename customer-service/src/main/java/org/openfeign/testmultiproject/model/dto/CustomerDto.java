package org.openfeign.testmultiproject.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String CustomerName;
    private String CustomerEmail;
}
