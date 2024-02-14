package com.comport.cp.user.service.impl;

import com.comport.cp.config.UserAuthProvider;
import com.comport.cp.exception.AppException;
import com.comport.cp.user.User;
import com.comport.cp.user.UserRepository;
import com.comport.cp.user.dto.UserLoginDto;
import com.comport.cp.user.service.UserService;
import com.comport.cp.user.dto.UserDto;
import com.comport.cp.user.dto.UserRegisterDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    final UserAuthProvider userAuthProvider;

    @Override
    public UserDto register(UserRegisterDto userRegisterDto, HttpServletResponse response) {
        User user = User.builder()
                .firstName(userRegisterDto.getFirstName())
                .lastName(userRegisterDto.getLastName())
                .email(userRegisterDto.getEmail())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();

        userRepository.save(user);

        Cookie cookie = createCookie(userAuthProvider.createToken(user));

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(cookie);

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public UserDto login(UserLoginDto userLoginDto, HttpServletResponse response) {
        User user = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new AppException("Invalid password", HttpStatus.UNAUTHORIZED);
        }

        Cookie cookie = createCookie(userAuthProvider.createToken(user));

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(cookie);

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    private Cookie createCookie(String token) {
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3_600);
        return cookie;
    }
}
