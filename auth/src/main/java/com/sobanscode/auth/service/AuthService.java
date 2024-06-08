package com.sobanscode.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.auth.data.dal.AuthServiceHelper;
import com.sobanscode.auth.data.entity.AuthTable;
import com.sobanscode.auth.data.entity.User;
import com.sobanscode.auth.data.enums.Roles;
import com.sobanscode.auth.dto.request.UserRegisterRequestDto;
import com.sobanscode.auth.dto.request.UserSaveDTO;
import com.sobanscode.auth.dto.response.GeneralRequestHeaderDTO;
import com.sobanscode.auth.dto.response.UserRegisterResponseDTO;
import com.sobanscode.auth.dto.response.UserResponseDTO;
import com.sobanscode.auth.exception.ApiError;
import com.sobanscode.auth.exception.AuthServiceException;
import com.sobanscode.auth.feign.IUserServiceFeign;
import com.sobanscode.auth.mapper.IAuthMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sobanscode.auth.exception.ApiError.COMPANY_NAME_NOT_MATCH;
import static com.sobanscode.auth.exception.ApiError.REGISTER_NOT_ALLOWED;

@Service
public class AuthService {

    private final AuthServiceHelper authServiceHelper;
    private final IUserServiceFeign userServiceFeign;
    private final IAuthMapper authMapper;
    private final ObjectMapper objectMapper;

    public AuthService(AuthServiceHelper authServiceHelper, IUserServiceFeign userServiceFeign, IAuthMapper authMapper, ObjectMapper objectMapper) {
        this.authServiceHelper = authServiceHelper;
        this.userServiceFeign = userServiceFeign;
        this.authMapper = authMapper;
        this.objectMapper = objectMapper;
    }

    public GeneralRequestHeaderDTO login(String username, String password){
        Optional<AuthTable> optionalAuthTable = Optional.ofNullable(authServiceHelper.findByUsernameAndPassword(username, password));
        GeneralRequestHeaderDTO generalRequestHeaderDTO = new GeneralRequestHeaderDTO();
        if(optionalAuthTable.isPresent()){
            AuthTable authTable = optionalAuthTable.get();
            UserResponseDTO userResponseDTO = userServiceFeign.getUserById(authTable.getUser().getId()).orElse(null);
            if(userResponseDTO != null){
                generalRequestHeaderDTO = GeneralRequestHeaderDTO.builder()
                        .userId(userResponseDTO.getId())
                        .name(userResponseDTO.getName())
                        .surname(userResponseDTO.getSurname())
                        .companyId(userResponseDTO.getCompanyId())
                        .role(authTable.getRole())
                        .build();
            }
        }
        else {
            throw new AuthServiceException(ApiError.USER_NOT_FOUND);
        }
        return generalRequestHeaderDTO;
    }

    // The transaction is not working. I couldn't understand it. I think it might be because I was expecting it to rollback a separate transaction in another microservice call.
    public UserRegisterResponseDTO register(String generalRequestHeader, UserRegisterRequestDto userRegisterRequestDto){

        GeneralRequestHeaderDTO generalRequestHeaderDTO = generalHeaderRequestConverter(generalRequestHeader);

        if(!isAdmin(generalRequestHeaderDTO))
            throw new AuthServiceException(REGISTER_NOT_ALLOWED);

        if(!userRegisterRequestDto.getCompanyName().equals(generalRequestHeaderDTO.getCompanyName()))
            throw new AuthServiceException((COMPANY_NAME_NOT_MATCH));

        UserResponseDTO userResponseDTO = userServiceFeign.save(UserSaveDTO.builder()
                        .name(userRegisterRequestDto.getName())
                        .surname(userRegisterRequestDto.getSurname())
                        .companyId(generalRequestHeaderDTO.getCompanyId())
                        .companyName(generalRequestHeaderDTO.getCompanyName())
                .build());

        User user = authMapper.toUserEntity(userResponseDTO);
        AuthTable authTable = authServiceHelper.save(
                userRegisterRequestDto.getUsername(),
                userRegisterRequestDto.getPassword(),
                user,
                userRegisterRequestDto.getRole());

        return UserRegisterResponseDTO.builder()
                .userId(user.getId())
                .username(user.getName())
                .name(user.getName())
                .surname(user.getSurname())
                .companyId(generalRequestHeaderDTO.getCompanyId())
                .companyName(generalRequestHeaderDTO.getCompanyName())
                .roles(authTable.getRole())
                .build();
    }

    public List<UserRegisterResponseDTO> registerAll(String generalRequestHeader, List<UserRegisterRequestDto> userRegisterRequestDtoList){
        List<UserRegisterResponseDTO> savedUsers = new ArrayList<>();
        userRegisterRequestDtoList
                .stream()
                .forEach(u -> savedUsers.add(register(generalRequestHeader, u)));

        return savedUsers;
    }


    private boolean isAdmin(GeneralRequestHeaderDTO generalRequestHeaderDto) {
        return generalRequestHeaderDto.getRole() == Roles.COMPANY_ADMIN;
    }

    private GeneralRequestHeaderDTO generalHeaderRequestConverter(String generalRequestHeader) {
        try {
            GeneralRequestHeaderDTO generalRequestHeaderDto = objectMapper.readValue(generalRequestHeader, GeneralRequestHeaderDTO.class);
            return generalRequestHeaderDto;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
