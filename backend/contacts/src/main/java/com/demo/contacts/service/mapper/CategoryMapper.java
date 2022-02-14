package com.demo.contacts.service.mapper;

import com.demo.contacts.model.Category;
import com.demo.contacts.service.dto.CategoryDto;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper extends ModelEntityMapper<Category, CategoryDto> {

    public Category toModel(CategoryDto dto) {
        Category model = super.toModel(dto, Category.class);
        model.setCategory(dto.getCategory());

        return model;
    }

    public CategoryDto toDto(Category model) {
        CategoryDto dto = super.toDto(model, CategoryDto.class);
        dto.setCategory(model.getCategory());

        return dto;
    }

}
