package com.comport.cp.user;

import com.comport.cp.user.dto.UserLoginDto;
import com.comport.cp.user.service.UserService;
import com.comport.cp.user.dto.UserDto;
import com.comport.cp.user.dto.UserRegisterDto;
import jakarta.servlet.http.HttpServletResponse;
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

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserRegisterDto userRegisterDto, HttpServletResponse response) {
        return ResponseEntity.ok(userService.register(userRegisterDto, response));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        return ResponseEntity.ok(userService.login(userLoginDto, response));
    }
}
