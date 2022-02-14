package com.demo.contacts.service.dto;

import com.demo.contacts.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeHistoryDto extends ModelEntityDto<Long> {

    private User userDto;
    private String field;
    private String oldValue;
    private String newValue;
    private String performedBy;
    private Date date;
}