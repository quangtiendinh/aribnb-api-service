package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.exception.AuthException;
import com.tiendinh.airbnb.mapper.UserMapper;
import com.tiendinh.airbnb.model.dto.UserDTO;
import com.tiendinh.airbnb.model.entity.User;
import com.tiendinh.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid user"));
    }

    @Override
    public UserDTO createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw AuthException.usernameExists(user.getUsername());
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw AuthException.emailExists(user.getUsername());
        }

        return userMapper.toDTO(userRepository.save(user));
    }
}
