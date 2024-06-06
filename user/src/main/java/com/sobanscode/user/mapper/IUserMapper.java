package com.sobanscode.user.mapper;

import com.sobanscode.user.data.entity.User;
import com.sobanscode.user.dto.request.UserSaveRequestDto;
import com.sobanscode.user.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {})
public interface IUserMapper {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.name", target = "companyName")
    UserResponseDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "companyName", target = "company.name")
    User toEntity(UserSaveRequestDto userSaveRequestDto);
}
