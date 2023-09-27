package com.youngjun.sns.user.dto.response;

import com.youngjun.sns.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String email;
    private String phoneNumber;
    private int age;

    public UserResponse(User user){
        this.id = user.getId();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
