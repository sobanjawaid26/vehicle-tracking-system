package com.sobanscode.auth.controller;

import com.sobanscode.auth.dto.request.UserRegisterRequestDto;
import com.sobanscode.auth.dto.response.GeneralRequestHeaderDTO;
import com.sobanscode.auth.dto.response.UserRegisterResponseDTO;
import com.sobanscode.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.sobanscode.auth.constants.ApiUrl.*;

@RestController
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(LOGIN)
    public ResponseEntity<GeneralRequestHeaderDTO> login(@RequestHeader("username") String username,
                                                         @RequestHeader("password") String password) {
        return ResponseEntity.ok(authService.login(username, password));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<UserRegisterResponseDTO> register(@RequestHeader("X-User") String generalRequestHeader,
                                                            @RequestBody @Valid UserRegisterRequestDto userRegisterRequestDto) {
        return ResponseEntity.ok(authService.register(generalRequestHeader, userRegisterRequestDto));
    }

    @PostMapping(REGISTER_ALL)
    public ResponseEntity<List<UserRegisterResponseDTO>> registerAll(@RequestHeader("X-User") String generalRequestHeader,
                                                                     @RequestBody @Valid List<UserRegisterRequestDto> userRegisterRequestDtoList) {
        //int k = 7 / 0;
        return ResponseEntity.ok(authService.registerAll(generalRequestHeader, userRegisterRequestDtoList));
    }
}
