package com.youngjun.sns.user.entity;

import com.youngjun.sns.user.dto.request.UpdateUserInfoRequest;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private int age;

    public void updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest){
        if(updateUserInfoRequest.email() != null){
            this.email = updateUserInfoRequest.email();
        }
        if(updateUserInfoRequest.age() != null){
            this.age = updateUserInfoRequest.age().intValue();
        }
        if(updateUserInfoRequest.phoneNumber() != null){
            this.phoneNumber = updateUserInfoRequest.phoneNumber();
        }
    }
}