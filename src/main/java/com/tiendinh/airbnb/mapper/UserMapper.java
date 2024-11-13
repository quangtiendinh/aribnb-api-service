package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.UserDTO;
import com.tiendinh.airbnb.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
}
