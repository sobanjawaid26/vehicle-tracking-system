package com.sobanscode.vehicle.data.repository;

import com.sobanscode.vehicle.data.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByCompanyId(Long companyId);
    List<Vehicle> findAllByCompanyIdAndGroupId(Long companyId, Long groupId);
    Optional<Vehicle> findByCompanyId(Long companyId);
    Optional<Vehicle> findByIdAndCompanyId(Long id, Long companyId);
    int deleteByIdAndCompanyId(Long id, Long companyId);
}
