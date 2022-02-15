package com.demo.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChangeHistory extends ModelEntity<Long> {

    @ManyToOne
    @JoinColumn()
    private User user;
    private String field;
    private String oldValue;
    private String newValue;
    private String performedBy;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChangeHistory that = (ChangeHistory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}