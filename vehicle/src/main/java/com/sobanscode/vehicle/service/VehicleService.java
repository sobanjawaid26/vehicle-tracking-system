package com.sobanscode.vehicle.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.vehicle.data.dal.VehicleServiceHelper;
import com.sobanscode.vehicle.feign.IGroupServiceFeign;
import com.sobanscode.vehicle.feign.IUserServiceFeign;
import com.sobanscode.vehicle.mapper.IGroupMapper;
import com.sobanscode.vehicle.mapper.IUserMapper;
import com.sobanscode.vehicle.mapper.IVehicleMapper;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleServiceHelper vehicleServiceHelper;
    private final IVehicleMapper vehicleMapper;
    private final IGroupMapper groupMapper;
    private final IUserMapper userMapper;
    private final ObjectMapper objectMapper;
    private final IGroupServiceFeign groupServiceFeign;
    private final IUserServiceFeign userServiceFeign;


    public VehicleService(VehicleServiceHelper vehicleServiceHelper, IVehicleMapper vehicleMapper, IGroupMapper groupMapper, IUserMapper userMapper, ObjectMapper objectMapper, IGroupServiceFeign groupServiceFeign, IUserServiceFeign userServiceFeign) {
        this.vehicleServiceHelper = vehicleServiceHelper;
        this.vehicleMapper = vehicleMapper;
        this.groupMapper = groupMapper;
        this.userMapper = userMapper;
        this.objectMapper = objectMapper;
        this.groupServiceFeign = groupServiceFeign;
        this.userServiceFeign = userServiceFeign;
    }


    // TODO saveVehicle
    // TODO saveAll
    // TODO getAllVehicles
    // TODO getVehicleById
    // TODO getAllVehicleByGroupName
    // TODO getAllVehicleForGroupNameWorkForStandardUser
    // TODO updateVehicle
    // TODO deleteVehicleByIdAndCompanyId
    // TODO isAdmin
    // TODO generalRequestHeaderConverter
    // TODO authorizeUserToVehicle
    // TODO getAllVehiclesByGroupId
    // TODO isUserAuthorizedToGroup
    // TODO getDirectlyAuthorizedVehicle
    // TODO updateVehicleGroup
}
