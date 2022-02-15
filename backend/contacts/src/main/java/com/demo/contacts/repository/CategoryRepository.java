package com.demo.contacts.repository;

import com.demo.contacts.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ModelEntityRepository<Category, Long> {

}