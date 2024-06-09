package com.sobanscode.vehicle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.vehicle.dto.request.VehicleSaveDTO;
import com.sobanscode.vehicle.dto.response.VehicleResponseDTO;
import com.sobanscode.vehicle.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sobanscode.vehicle.constants.ApiUrl.*;
import static com.sobanscode.vehicle.constants.SwaggerDescriptions.DESCRIPTION1;

@RestController
@RequestMapping(VEHICLES)
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService, ObjectMapper objectMapper) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(SAVE)
    @Operation(description = DESCRIPTION1)
    public ResponseEntity<VehicleResponseDTO> save(@RequestHeader("X-User") String generalRequestHeader, @RequestBody VehicleSaveDTO vehicleSaveDTO) {
        VehicleResponseDTO savedVehicle = vehicleService.saveVehicle(generalRequestHeader, vehicleSaveDTO);
        return ResponseEntity.ok(savedVehicle);
    }
}
