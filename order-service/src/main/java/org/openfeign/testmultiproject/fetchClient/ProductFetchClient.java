package org.openfeign.testmultiproject.fetchClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8081/api/v1/product")
public interface ProductFetchClient {

    @GetMapping("productId")
    ResponseEntity<?> getProductsByIds(@RequestParam("productId") List<Long> productIds);

}
