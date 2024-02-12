package com.comport.cp.user.service;

import com.comport.cp.user.service.dto.UserDto;
import com.comport.cp.user.service.dto.UserRegisterDto;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    UserDto register(UserRegisterDto userRegisterDto, HttpServletResponse response);
}
