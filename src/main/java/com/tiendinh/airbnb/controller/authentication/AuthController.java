package com.tiendinh.airbnb.controller.authentication;

import com.tiendinh.airbnb.controller.authentication.request.LoginRequest;
import com.tiendinh.airbnb.controller.authentication.request.UserAddRequest;
import com.tiendinh.airbnb.controller.authentication.response.UserLoginDTO;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.model.dto.UserDTO;
import com.tiendinh.airbnb.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApiDoc {

    private final AuthService authService;

    @Override
    public ResponseEntity<UserLoginDTO> login(LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Override
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserAddRequest request) throws BusinessLogicException {
        return ResponseEntity.ok(authService.register(request));
    }
}
