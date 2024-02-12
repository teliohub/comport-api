package com.comport.cp.user.service;

import com.comport.cp.user.dto.UserDto;
import com.comport.cp.user.dto.UserLoginDto;
import com.comport.cp.user.dto.UserRegisterDto;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    UserDto register(UserRegisterDto userRegisterDto, HttpServletResponse response);

    UserDto login(UserLoginDto userLoginDto, HttpServletResponse response);
}
