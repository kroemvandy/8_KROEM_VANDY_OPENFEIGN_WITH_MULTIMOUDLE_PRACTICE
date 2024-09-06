package org.openfeign.testmultiproject.fetchClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service", url = "http://localhost:8082/api/v1/customer")
public interface CustomerFetchClient {

    @GetMapping("/{cusId}")
    ResponseEntity<?> getCustomerById(@PathVariable("cusId") Long cusId);

}
