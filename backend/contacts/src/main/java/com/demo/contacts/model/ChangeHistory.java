package com.demo.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChangeHistory extends ModelEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String field;
    private String oldValue;
    private String newValue;
    private String performedBy;
    private Date date;
}