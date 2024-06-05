package com.sobanscode.vehicle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.vehicle.service.VehicleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.sobanscode.vehicle.constants.ApiUrl.*;

@RestController
@RequestMapping(VEHICLES)
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService, ObjectMapper objectMapper) {
        this.vehicleService = vehicleService;
    }
}
