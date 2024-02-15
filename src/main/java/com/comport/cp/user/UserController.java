package com.comport.cp.user;

import com.comport.cp.user.dto.UserDto;
import com.comport.cp.user.dto.UserLoginDto;
import com.comport.cp.user.dto.UserRegisterDto;
import com.comport.cp.user.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserRegisterDto userRegisterDto, HttpServletResponse response) {
        return ResponseEntity.ok(userService.register(userRegisterDto, response));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid UserLoginDto userLoginDto, HttpServletResponse response) {
        return ResponseEntity.ok(userService.login(userLoginDto, response));
    }
}
