package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.model.dto.UserDTO;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    UserDTO createUser(User user);
}
