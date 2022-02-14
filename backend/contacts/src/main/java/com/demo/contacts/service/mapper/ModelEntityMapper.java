package com.demo.contacts.service.mapper;

import com.demo.contacts.model.ModelEntity;
import com.demo.contacts.service.dto.ModelEntityDto;

import lombok.SneakyThrows;

import org.springframework.stereotype.Service;

@Service
public abstract class ModelEntityMapper<T extends ModelEntity, TDto extends ModelEntityDto> {

    @SneakyThrows
    public T toModel(TDto dto, Class<T> modelClass)  {
        T model = modelClass.getDeclaredConstructor().newInstance();
        model.setId(dto.getId());

        return model;
    }

    @SneakyThrows
    public TDto toDto(T model,  Class<TDto> dtoClass) {
        TDto tDto = dtoClass.getDeclaredConstructor().newInstance();
        tDto.setId(model.getId());

        return tDto;
    }
}