package com.demo.contacts.service;

import com.demo.contacts.model.User;
import com.demo.contacts.repository.UserRepository;
import com.demo.contacts.service.dto.UserDto;
import com.demo.contacts.service.dto.PagedResultsDto;
import com.demo.contacts.service.mapper.UserMapper;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public PagedResultsDto<UserDto> getAllFiltered(String firstOrLastName, Pageable pageable) {
        Page<User> users = firstOrLastName.equals(Strings.EMPTY) ? repository.findAll(pageable) :
                repository.findAllByFirstNameContainingOrLastNameContaining(firstOrLastName, firstOrLastName, pageable);

        List<UserDto> userDtos = users.getContent().stream().map(c -> mapper.toDto(c)).collect(Collectors.toList());
        return new PagedResultsDto<>(userDtos, users.getNumber(), users.getNumberOfElements(), users.getTotalPages() , users.getTotalElements());
    }

    public UserDto getById(Long id) {
        User User = repository.getById(id);
        return mapper.toDto(User);
    }

    public UserDto getByEmail(String email) {
        User user = repository.getByEmail(email);
        return mapper.toDto(user);
    }

    public UserDto save(User user) {
        User savedContact = repository.save(user);
        return mapper.toDto(savedContact);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}