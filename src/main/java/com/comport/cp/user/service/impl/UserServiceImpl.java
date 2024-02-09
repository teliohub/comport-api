package com.comport.cp.user.service.impl;

import com.comport.cp.user.User;
import com.comport.cp.user.UserRepository;
import com.comport.cp.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
}
