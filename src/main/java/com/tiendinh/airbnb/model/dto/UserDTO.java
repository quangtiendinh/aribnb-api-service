package com.tiendinh.airbnb.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String passwordHash;
    private String phoneNumber;
    private String profilePicture;
    private String bio;
    private boolean isHost = false;
}
