package com.demo.contacts.repository;

import com.demo.contacts.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends ModelEntityRepository<User, Long> {

    Page<User> getAllByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}