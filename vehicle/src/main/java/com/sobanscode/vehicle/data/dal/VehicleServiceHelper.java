package com.sobanscode.vehicle.data.dal;

import com.sobanscode.vehicle.data.entity.User;
import com.sobanscode.vehicle.data.entity.UserVehicleAuthorization;
import com.sobanscode.vehicle.data.entity.Vehicle;
import com.sobanscode.vehicle.data.repository.IUserVehicleAuthorizationRepository;
import com.sobanscode.vehicle.data.repository.IVehicleRepository;
import com.sobanscode.vehicle.mapper.IVehicleMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleServiceHelper {
    private final IVehicleRepository vehicleRepository;
    private final IUserVehicleAuthorizationRepository userVehicleAuthorizationRepository;
    private final IVehicleMapper vehicleMapper;

    public VehicleServiceHelper(IVehicleRepository vehicleRepository, IUserVehicleAuthorizationRepository userVehicleAuthorizationRepository, IVehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.userVehicleAuthorizationRepository = userVehicleAuthorizationRepository;
        this.vehicleMapper = vehicleMapper;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleByIdAndCompanyId(Long id, Long companyId) {
        return vehicleRepository.findByIdAndCompanyId(id, companyId);
    }

    public List<Vehicle> getAllVehicles(Long companyId) {
        return vehicleRepository.findAllByCompanyId(companyId);
    }

    public List<Vehicle> getAllVehiclesByCompanyIdAndGroupId(long companyId, long groupId) {
        return vehicleRepository.findAllByCompanyIdAndGroupId(companyId, groupId);
    }

    public int deleteVehicleByIdAndCompanyId(long id, long companyId) {
        return vehicleRepository.deleteByIdAndCompanyId(id, companyId);
    }

    public void saveUserVehicleAuth(Vehicle vehicle, User user) {
        UserVehicleAuthorization userVehicleAuthorization = UserVehicleAuthorization.builder()
                .user(user)
                .vehicle(vehicle)
                .build();

        userVehicleAuthorizationRepository.save(userVehicleAuthorization);
    }

    public List<UserVehicleAuthorization> getDirectlyAuthorizedVehicles(long userId) {
        return userVehicleAuthorizationRepository.findAllByUserId(userId);
    }
}