package com.demo.contacts.service.mapper;

import com.demo.contacts.model.User;
import com.demo.contacts.service.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserMapper extends ModelEntityMapper<User, UserDto> {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ChangeHistoryMapper changeHistoryMapper;

    public User toModel(UserDto dto) {
        User model = super.toModel(dto, User.class);

        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getEmail());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setCategory(categoryMapper.toModel(dto.getCategory()));
        model.setNotes(dto.getNotes());
        model.setChangesHistory(dto.getChangesHistory().stream().map(ch -> changeHistoryMapper.toModel(ch)).collect(Collectors.toList()));
        return model;
    }

    public UserDto toDto(User model) {
        UserDto dto = super.toDto(model, UserDto.class);

        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmail(model.getEmail());
        dto.setPhoneNumber(model.getPhoneNumber());
        if (model.getCategory() != null) {
            dto.setCategory(categoryMapper.toDto(model.getCategory()));
        }
        dto.setNotes(model.getNotes());
        dto.setChangesHistory(model.getChangesHistory().stream().map(ch -> changeHistoryMapper.toDto(ch)).collect(Collectors.toList()));
        return dto;
    }
}