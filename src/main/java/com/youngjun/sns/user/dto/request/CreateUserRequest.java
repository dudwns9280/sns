package com.youngjun.sns.user.dto.request;

import jakarta.validation.constraints.*;

public record CreateUserRequest(
        @NotNull
        @Email(message = "올바른 이메일 형식을 입력해주세요.")
        String email,
        @NotNull
        @Size(min=8, message = "비밀번호는 8자리 이상으로 입력해주세요.")
        String password,
        @Pattern(regexp = "\\d{3}-((\\d{4})|(\\d{3}))-\\d{4}", message = "전화번호를 올바른 형식으로 입력해주세요. (-포함)")
        String phoneNumber,
        @Max(100)
        int age){
}