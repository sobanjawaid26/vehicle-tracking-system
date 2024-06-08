package com.sobanscode.auth.feign;

import com.sobanscode.auth.dto.request.UserSaveDTO;
import com.sobanscode.auth.dto.response.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(url = "http://localhost:8083/api/v1/users", name = "user")
public interface IUserServiceFeign {

    @GetMapping("{id}")
    Optional<UserResponseDTO> getUserById(@PathVariable("id") Long id);

    @PostMapping("/save")
    @Transactional(propagation = Propagation.REQUIRED)
    UserResponseDTO save(UserSaveDTO userSaveDTO);
}
