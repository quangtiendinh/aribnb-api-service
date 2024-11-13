package com.tiendinh.airbnb.controller.authentication.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginDTO {
    private String accessToken;
}
