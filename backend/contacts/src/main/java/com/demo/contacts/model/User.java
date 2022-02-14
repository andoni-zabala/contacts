package com.demo.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends ModelEntity<Long> {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    private String phoneNumber;

    @OneToOne
    @JoinTable(name = "userCategory",
            joinColumns =
                    { @JoinColumn(name = "userId", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "categoryId", referencedColumnName = "id") })
    private Category category;
}