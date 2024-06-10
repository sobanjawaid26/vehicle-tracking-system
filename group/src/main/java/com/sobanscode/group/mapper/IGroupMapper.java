package com.sobanscode.group.mapper;

import com.sobanscode.group.data.entity.Group;
import com.sobanscode.group.dto.request.GroupSaveDTO;
import com.sobanscode.group.dto.response.GroupResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, implementationName = "GroupMapperImpl", componentModel = "spring")
public interface IGroupMapper {
    @Mapping(target = "companyId", source = "company.id")
    GroupResponseDTO toDto(Group group);

    @Mapping(target = "company.id", source = "companyId")
    Group toEntity(GroupResponseDTO groupResponseDTO);

    @Mapping(target = "company.id", source = "companyId")
    Group toEntity(GroupSaveDTO groupSaveDTO);
}
