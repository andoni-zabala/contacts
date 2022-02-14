package com.demo.contacts.service.mapper;

import com.demo.contacts.model.User;
import com.demo.contacts.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMapper extends ModelEntityMapper<User, UserDto> {

    @Autowired
    private CategoryMapper categoryMapper;

    public User toModel(UserDto dto) {
        User model = super.toModel(dto, User.class);

        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getPhoneNumber());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setCategory(categoryMapper.toModel(dto.getCategory()));
        return model;
    }

    public UserDto toDto(User model) {
        UserDto dto = super.toDto(model, UserDto.class);

        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmail(model.getPhoneNumber());
        dto.setPhoneNumber(model.getPhoneNumber());
        if (model.getCategory() != null) {
            dto.setCategory(categoryMapper.toDto(model.getCategory()));
        }
        return dto;
    }

}
