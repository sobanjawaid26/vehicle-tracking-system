package com.sobanscode.vehicle.mapper;

import com.sobanscode.vehicle.data.entity.Group;
import com.sobanscode.vehicle.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, implementationName = "GroupMapperImpl", componentModel = "spring")
public interface IGroupMapper {
    @Mapping(target = "company.id", source = "companyId")
    Group toEntity(GroupDTO groupDTO);
}
