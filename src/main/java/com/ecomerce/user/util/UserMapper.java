package com.ecomerce.user.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.entity.UserEntity;

@Component
public class UserMapper {
	
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserEntity toEntity(User dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    public static User toDTO(UserEntity entity) {
        return modelMapper.map(entity, User.class);
    }
}
