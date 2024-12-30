package com.microservice.employee.client;

import com.microservice.employee.response.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//REST API Call using Feign Client

/**
 * LOAD BALANCER= loads the urls if the service has multiple ports
 * If we have our service running in multiple ports we can get it using load balancer instead of hardcoding the url
 * Client Side Load Balancer -Ribbon
 */

//@FeignClient(name="address-service" ,url = "http://localhost:8081" ,path = "/address-service/api")
@FeignClient(name="address-service",path="address-service/api")
@RibbonClient(name = "address-service")
public interface AddressClient {

    @GetMapping("/getAddress/{addr_id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("addr_id") int id);
}
