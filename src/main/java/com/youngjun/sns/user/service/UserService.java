package com.youngjun.sns.user.service;

import com.youngjun.sns.user.dto.request.CreateUserRequest;
import com.youngjun.sns.user.dto.request.UpdateUserRequest;
import com.youngjun.sns.user.entity.User;
import com.youngjun.sns.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("유저 정보 없음")
        );
    }

    public User createUser(CreateUserRequest createUserRequest){
        User user = User.builder()
                .email(createUserRequest.email())
                .phoneNumber(createUserRequest.phoneNumber())
                .age(createUserRequest.age())
                .password(createUserRequest.password())
                .build();
        return userRepository.save(user);
    }

    public User updateUser(Long id, UpdateUserRequest updateUserRequest){
        User user = this.getUserById(id);
        user.updateUser(updateUserRequest);
        return userRepository.save(user);
    }
}


