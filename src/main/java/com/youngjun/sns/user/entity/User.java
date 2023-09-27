package com.youngjun.sns.user.entity;

import com.youngjun.sns.user.dto.request.UpdateUserRequest;
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

    public void updateUser(UpdateUserRequest updateUserRequest){
        if(updateUserRequest.email() != null){
            this.email = updateUserRequest.email();
        }
        if(updateUserRequest.password() != null){
            this.password = updateUserRequest.password();
        }
        if(updateUserRequest.age() != null){
            this.age = updateUserRequest.age().intValue();
        }
        if(updateUserRequest.phoneNumber() != null){
            this.phoneNumber = updateUserRequest.phoneNumber();
        }
    }
}