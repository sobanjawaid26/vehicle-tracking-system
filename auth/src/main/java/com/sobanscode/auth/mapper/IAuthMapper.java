package com.sobanscode.auth.mapper;

import com.sobanscode.auth.dto.request.UserRegisterRequestDto;
import com.sobanscode.auth.dto.response.UserResponseDTO;
import com.sobanscode.auth.data.entity.AuthTable;
import com.sobanscode.auth.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {
    AuthTable toAuth(UserRegisterRequestDto dto);

    User toUserEntity(UserResponseDTO dto);
}
