package com.demo.contacts.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends ModelEntityDto<Long> {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private CategoryDto category;
    private List<ChangeHistoryDto> changesHistory;
}
