package com.sobanscode.user.controller;

import com.sobanscode.user.dto.request.UserSaveRequestDto;
import com.sobanscode.user.dto.response.UserResponseDTO;
import com.sobanscode.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sobanscode.user.constants.ApiUrl.*;

@RestController
@RequestMapping(USERS)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id){
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(SAVE)
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return ResponseEntity.ok(userService.save(userSaveRequestDto));
    }

    @PostMapping(SAVE_ALL)
    public ResponseEntity<List<UserResponseDTO>> saveAll(@RequestBody List<UserSaveRequestDto> userSaveRequestDtoList){
        return ResponseEntity.ok(userService.saveAll(userSaveRequestDtoList));
    }
}
