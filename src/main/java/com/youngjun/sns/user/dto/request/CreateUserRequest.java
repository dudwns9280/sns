package com.youngjun.sns.user.dto.request;

import com.youngjun.sns.user.entity.User;

public record CreateUserRequest(
        String email,
        String password,
        String phoneNumber,
        Long age
){
}