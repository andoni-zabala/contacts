package com.demo.contacts.service;

import com.demo.contacts.model.Category;
import com.demo.contacts.model.User;
import com.demo.contacts.repository.CategoryRepository;
import com.demo.contacts.service.dto.CategoryDto;
import com.demo.contacts.service.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ModelEntityService<Long, Category, CategoryDto>{

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDto> getAllFiltered() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(c -> mapper.toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = repository.getById(id);
        return mapper.toDto(category);
    }

    @Override
    public CategoryDto save(Category category) {
        Category savedCategory = repository.save(category);
        return mapper.toDto(savedCategory);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}