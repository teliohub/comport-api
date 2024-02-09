package com.comport.cp.user.service.impl;

import com.comport.cp.config.UserAuthProvider;
import com.comport.cp.user.User;
import com.comport.cp.user.UserRepository;
import com.comport.cp.user.service.UserService;
import com.comport.cp.user.service.dto.UserDto;
import com.comport.cp.user.service.dto.UserRegisterDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    public UserDto register(UserRegisterDto userRegisterDto) {
        User user = User.builder()
                .firstName(userRegisterDto.getFirstName())
                .lastName(userRegisterDto.getLastName())
                .email(userRegisterDto.getEmail())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();

        userRepository.save(user);

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .token(userAuthProvider.createToken(user))
                .build();
    }
}
