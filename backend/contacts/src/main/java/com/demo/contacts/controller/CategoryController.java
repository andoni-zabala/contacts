package com.demo.contacts.controller;

import com.demo.contacts.service.CategoryService;
import com.demo.contacts.service.dto.CategoryDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> categoryDtos = service.getAllFiltered();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
}