package com.sobanscode.group.data.repository;

import com.sobanscode.group.data.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByIdAndCompanyId(Long groupId, Long companyId);

    Set<Group> findAllByCompanyIdAndAndRootIsTrue(Long companyId);

    void deleteByIdAndCompanyId(Long id, Long companyId);
}
