package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.config.JwtProvider;
import com.tiendinh.airbnb.controller.authentication.request.LoginRequest;
import com.tiendinh.airbnb.controller.authentication.request.UserAddRequest;
import com.tiendinh.airbnb.controller.authentication.response.UserLoginDTO;
import com.tiendinh.airbnb.model.auth.UserJwtClaim;
import com.tiendinh.airbnb.model.dto.UserDTO;
import com.tiendinh.airbnb.model.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserLoginDTO login(LoginRequest request) {
        var authenticationInput = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var authentication = authenticationManager.authenticate(authenticationInput);

        var subject = request.getUsername();
        var claims = toJwtClaim((User) authentication.getPrincipal());
        var accessToken = jwtProvider.generateJwtAccessToken(subject, claims);

        return UserLoginDTO.builder()
                .accessToken(accessToken)
                .build();
    }

    @Override
    public UserDTO register(UserAddRequest request) {
        var user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        return userService.createUser(user);
    }

    private UserJwtClaim toJwtClaim(User user) {
        var claim = new UserJwtClaim();
        claim.setUsername(user.getUsername());
        claim.setAuthorities(user
                .getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .collect(toList()));
        return claim;
    }
}
