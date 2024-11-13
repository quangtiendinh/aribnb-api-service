package com.tiendinh.airbnb.model.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserAuthority implements Serializable {
    private String identifier;
    private List<String> authorities;
}
