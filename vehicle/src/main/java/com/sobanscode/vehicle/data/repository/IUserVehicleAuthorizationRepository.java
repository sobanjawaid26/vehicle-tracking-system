package com.sobanscode.vehicle.data.repository;

import com.sobanscode.vehicle.data.entity.UserVehicleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserVehicleAuthorizationRepository extends JpaRepository<UserVehicleAuthorization, Long> {

    UserVehicleAuthorization findByUserIdAndVehicleId(Long userId, Long vehicleId);

    List<UserVehicleAuthorization> findAllByUserId(Long userId);
}
