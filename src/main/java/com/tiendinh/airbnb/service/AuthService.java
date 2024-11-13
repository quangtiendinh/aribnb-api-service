package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.authentication.request.LoginRequest;
import com.tiendinh.airbnb.controller.authentication.request.UserAddRequest;
import com.tiendinh.airbnb.controller.authentication.response.UserLoginDTO;
import com.tiendinh.airbnb.model.dto.UserDTO;

public interface AuthService {
    UserLoginDTO login(LoginRequest request);
    UserDTO register(UserAddRequest request);
}
