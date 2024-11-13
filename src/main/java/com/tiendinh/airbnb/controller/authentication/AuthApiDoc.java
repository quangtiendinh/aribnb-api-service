package com.tiendinh.airbnb.controller.authentication;


import com.tiendinh.airbnb.controller.authentication.request.LoginRequest;
import com.tiendinh.airbnb.controller.authentication.request.UserAddRequest;
import com.tiendinh.airbnb.controller.authentication.response.UserLoginDTO;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPath.AUTH)
@Tag(name = "Auth", description = "Authentication For System User")
public interface AuthApiDoc {

    @PostMapping(ApiPath.LOGIN)
    default ResponseEntity<UserLoginDTO> login(@Valid @RequestBody LoginRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(ApiPath.REGISTER)
    default ResponseEntity<UserDTO> register(@Valid @RequestBody UserAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
