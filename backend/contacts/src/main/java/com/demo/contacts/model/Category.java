package com.demo.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends ModelEntity<Long>{

    private String category;
}
