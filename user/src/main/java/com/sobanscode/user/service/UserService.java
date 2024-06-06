package com.sobanscode.user.service;

import com.sobanscode.user.data.dal.UserServiceHelper;
import com.sobanscode.user.data.entity.User;
import com.sobanscode.user.dto.request.UserSaveRequestDto;
import com.sobanscode.user.dto.response.UserResponseDTO;
import com.sobanscode.user.mapper.IUserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserServiceHelper userServiceHelper;
    private final IUserMapper userMapper;

    public UserService(UserServiceHelper userServiceHelper, IUserMapper userMapper) {
        this.userServiceHelper = userServiceHelper;
        this.userMapper = userMapper;
    }

    public Optional<UserResponseDTO> getUserById(long id){
        return userServiceHelper.getUserId(id).map(userMapper::toDto);
    }

    public UserResponseDTO save(UserSaveRequestDto userSaveRequestDto){
        return userMapper.toDto(userServiceHelper.save(userMapper.toEntity(userSaveRequestDto)));
    }

    public List<UserResponseDTO> saveAll(List<UserSaveRequestDto> userSaveRequestDtoList){
        List<UserResponseDTO> savedDtoList = new ArrayList<>();

        userSaveRequestDtoList.forEach(userSaveDto -> {
            savedDtoList.add(userMapper.toDto(userServiceHelper.save(userMapper.toEntity(userSaveDto))));
        });

        return savedDtoList;
    }
}
