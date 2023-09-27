package com.youngjun.sns.user.dto.request;

public record UpdateUserRequest(
        String email,
        String password,
        String phoneNumber,
        Integer age) {

}
