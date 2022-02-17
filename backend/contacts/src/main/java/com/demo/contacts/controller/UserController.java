package com.demo.contacts.controller;

import com.demo.contacts.model.User;
import com.demo.contacts.service.UserService;
import com.demo.contacts.service.dto.UserDto;
import com.demo.contacts.service.dto.PagedResultsDto;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAllFiltered")
    public ResponseEntity<PagedResultsDto<UserDto>> getAllFiltered(@RequestParam(defaultValue = Strings.EMPTY) String nameOrLastName,
                                                                   Pageable pageable) {
        PagedResultsDto<UserDto> pagedResultsDto = service.getAllFiltered(nameOrLastName, pageable);
        return new ResponseEntity<>(pagedResultsDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        UserDto userDto = service.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("by-email/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {
        UserDto userDto = service.getByEmail(email);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody User user) {
        UserDto savedUser = service.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}