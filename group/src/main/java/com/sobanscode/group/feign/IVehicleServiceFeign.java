package com.sobanscode.group.feign;

import com.sobanscode.group.dto.request.VehicleGroupUpdateDTO;
import com.sobanscode.group.dto.response.VehicleResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/v1/vehicles",name = "vehicle")
public interface IVehicleServiceFeign {

    @GetMapping("/get-vehicles-by-group-id/{groupId}")
    List<VehicleResponseDTO> getAllVehiclesByGroupId(@RequestHeader("X-User") String generalRequestHeader, @PathVariable("groupId") long groupId);

    @GetMapping("/get-directly-authorized-vehicle")
    List<VehicleResponseDTO> getDirectlyAuthorizedVehicle(@RequestHeader("X-User") String generalRequestHeader);

    @GetMapping("/get-directly-authorized-vehicles-by-user-id")
    List<VehicleResponseDTO> getDirectlyAuthorizedVehicle(@RequestHeader("X-User") String generalRequestHeader, @RequestParam("userId") Long userId);

    @PutMapping("/update-vehicle-group")
    VehicleResponseDTO updateVehicleGroup(@RequestHeader("X-User") String generalRequestHeader, @RequestBody VehicleGroupUpdateDTO vehicleGroupUpdateDTO);
}