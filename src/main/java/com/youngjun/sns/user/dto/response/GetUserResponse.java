package com.youngjun.sns.user.dto.response;

import com.youngjun.sns.user.entity.User;
import lombok.Getter;

@Getter
public class GetUserResponse {
    private Long id;
    private String email;
    private String phoneNumber;
    private Long age;

    public GetUserResponse(User user){
        this.id = user.getId();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
