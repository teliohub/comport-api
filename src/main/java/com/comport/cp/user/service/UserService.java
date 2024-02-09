package com.comport.cp.user.service;

import com.comport.cp.user.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(String id);
}
