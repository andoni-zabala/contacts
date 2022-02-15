package com.demo.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(length = 200)
    private String notes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true, fetch=FetchType.EAGER)
    private List<ChangeHistory> changesHistory;
}