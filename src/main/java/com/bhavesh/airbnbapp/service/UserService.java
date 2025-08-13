package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.ProfileUpdateRequestDto;
import com.bhavesh.airbnbapp.dto.UserDto;
import com.bhavesh.airbnbapp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
