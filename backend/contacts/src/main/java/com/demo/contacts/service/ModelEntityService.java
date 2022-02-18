package com.demo.contacts.service;

public interface ModelEntityService<IdType, T, TDto> {

    TDto getById(Long IdType);

    TDto save(T entity);

    void deleteById(IdType id);
}
