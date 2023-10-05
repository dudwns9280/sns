package com.youngjun.sns.user.dto.request;

public record UpdateUserInfoRequest(
        String email,
        String phoneNumber,
        Integer age) {

}
