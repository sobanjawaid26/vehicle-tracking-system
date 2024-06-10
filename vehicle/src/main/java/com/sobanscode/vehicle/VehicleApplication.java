package com.sobanscode.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehicleApplication {
    public static void main(String[] args) {
        SpringApplication.run(VehicleApplication.class);
    }
}
