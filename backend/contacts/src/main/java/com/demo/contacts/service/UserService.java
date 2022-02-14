package com.demo.contacts.service;

import com.demo.contacts.model.User;
import com.demo.contacts.repository.ContactRepository;
import com.demo.contacts.service.dto.UserDto;
import com.demo.contacts.service.dto.PagedResultsDto;
import com.demo.contacts.service.mapper.ContactMapper;
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
    private ContactRepository repository;

    @Autowired
    private ContactMapper mapper;

    public PagedResultsDto<UserDto> getAllFiltered(String firstOrLastName, Pageable pageable) {
        Page<User> users = firstOrLastName.equals(Strings.EMPTY) ? repository.findAll(pageable) :
                repository.getAllByFirstNameOrLastName(firstOrLastName, firstOrLastName, pageable);
        List<UserDto> userDtos = users.getContent().stream().map(c -> mapper.toDto(c)).collect(Collectors.toList());

        return new PagedResultsDto<>(userDtos, users.getTotalElements(), users.getTotalPages());
    }
    public UserDto getById(Long id) {
        User User = repository.getById(id);
        return mapper.toDto(User);
    }

    public UserDto save(User User) {
        User savedContact = repository.save(User);
        return mapper.toDto(savedContact);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}