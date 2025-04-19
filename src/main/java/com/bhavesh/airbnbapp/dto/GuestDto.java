package com.bhavesh.airbnbapp.dto;

import com.bhavesh.airbnbapp.entity.User;
import com.bhavesh.airbnbapp.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;

}
