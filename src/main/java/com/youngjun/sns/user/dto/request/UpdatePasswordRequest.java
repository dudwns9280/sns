package com.youngjun.sns.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePasswordRequest(
        @NotNull
        @Email(message = "올바른 이메일 형식을 입력해주세요.")
        String email,
        @NotNull
        @Size(min=8, message = "비밀번호는 8자리 이상으로 입력해주세요.")
        String originPassword,
        @NotNull
        @Size(min=8, message = "비밀번호는 8자리 이상으로 입력해주세요.")
        String changePassword) {
}
