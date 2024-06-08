package com.sobanscode.apigateway.feign;

import com.sobanscode.apigateway.dto.request.GeneralRequestHeaderDto;
import com.sobanscode.apigateway.feign.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8084/api/v1/auth",name = "auth-service", configuration = FeignConfiguration.class)
public interface IAuthServiceFeign {
    @GetMapping("/login")
    GeneralRequestHeaderDto login(@RequestHeader("username") String username, @RequestHeader("password") String password);
}

