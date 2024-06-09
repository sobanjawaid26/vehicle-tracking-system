package com.sobanscode.vehicle.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.vehicle.data.dal.VehicleServiceHelper;
import com.sobanscode.vehicle.data.entity.Company;
import com.sobanscode.vehicle.data.entity.Vehicle;
import com.sobanscode.vehicle.data.enums.Roles;
import com.sobanscode.vehicle.dto.GroupDTO;
import com.sobanscode.vehicle.dto.request.GeneralRequestHeaderDTO;
import com.sobanscode.vehicle.dto.request.VehicleSaveDTO;
import com.sobanscode.vehicle.dto.response.VehicleResponseDTO;
import com.sobanscode.vehicle.exception.ApiError;
import com.sobanscode.vehicle.exception.VehicleServiceException;
import com.sobanscode.vehicle.feign.IGroupServiceFeign;
import com.sobanscode.vehicle.feign.IUserServiceFeign;
import com.sobanscode.vehicle.mapper.IGroupMapper;
import com.sobanscode.vehicle.mapper.IUserMapper;
import com.sobanscode.vehicle.mapper.IVehicleMapper;
import org.springframework.stereotype.Service;

import static com.sobanscode.vehicle.exception.ApiError.USER_NOT_COMPANY_ADMIN;

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
    public VehicleResponseDTO saveVehicle(String generalRequestHeader, VehicleSaveDTO vehicleSaveDTO){

        GeneralRequestHeaderDTO generalRequestHeaderDTO =
                generalRequestHeaderConverter(generalRequestHeader);

        if(generalRequestHeaderDTO.getRole() != Roles.COMPANY_ADMIN)
            throw new VehicleServiceException(USER_NOT_COMPANY_ADMIN);

        GroupDTO groupDTO = groupServiceFeign.getById(generalRequestHeader, vehicleSaveDTO.getGroupId());

        Vehicle vehicle = vehicleMapper.toEntity(vehicleSaveDTO);
        vehicle.setGroup((groupMapper.toEntity(groupDTO)));
        Company company = new Company();
        company.setId(generalRequestHeaderDTO.getCompanyId());
        vehicle.setCompany(company);

        return vehicleMapper.toDto(vehicleServiceHelper.saveVehicle(vehicle));
    }
    // TODO saveAll
    // TODO getAllVehicles
    // TODO getVehicleById
    // TODO getAllVehicleByGroupName
    // TODO getAllVehicleForGroupNameWorkForStandardUser
    // TODO updateVehicle
    // TODO deleteVehicleByIdAndCompanyId
    // TODO isAdmin
    // TODO generalRequestHeaderConverter
    GeneralRequestHeaderDTO generalRequestHeaderConverter(String generalRequestHeader){
        try {
            GeneralRequestHeaderDTO generalRequestHeaderDTO =
                    objectMapper.readValue(generalRequestHeader, GeneralRequestHeaderDTO.class);
            return generalRequestHeaderDTO;
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
    // TODO authorizeUserToVehicle
    // TODO getAllVehiclesByGroupId
    // TODO isUserAuthorizedToGroup
    // TODO getDirectlyAuthorizedVehicle
    // TODO updateVehicleGroup
}
