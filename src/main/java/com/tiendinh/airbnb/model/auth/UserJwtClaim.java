package com.tiendinh.airbnb.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJwtClaim extends UserAuthority {
    private String username;
    private List<String> authorities;

    @Override
    public String getIdentifier() {
        return username;
    }
}
