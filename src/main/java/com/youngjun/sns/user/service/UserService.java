package com.youngjun.sns.user.service;

import com.youngjun.sns.user.dto.request.CreateUserRequest;
import com.youngjun.sns.user.dto.request.UpdatePasswordRequest;
import com.youngjun.sns.user.dto.request.UpdateUserInfoRequest;
import com.youngjun.sns.user.entity.User;
import com.youngjun.sns.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("유저 정보 없음")
        );
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("유저 정보 없음")
        );
    }

    public User createUser(CreateUserRequest createUserRequest){
        String password = passwordEncoder.encode(createUserRequest.password());
        User user = User.builder()
                .email(createUserRequest.email())
                .phoneNumber(createUserRequest.phoneNumber())
                .age(createUserRequest.age())
                .password(password)
                .build();
        return userRepository.save(user);
    }

    public User updateUserInfo(Long id, UpdateUserInfoRequest updateUserInfoRequest){
        User user = this.getUserById(id);
        user.updateUserInfo(updateUserInfoRequest);
        return userRepository.save(user);
    }
    public User updatePassword(UpdatePasswordRequest updatePasswordRequest){
        User user = this.getUserByEmail(updatePasswordRequest.email());
        if(!passwordEncoder.matches(updatePasswordRequest.originPassword(), user.getPassword())){
            throw new RuntimeException("기존 비밀번호 일치 하지 않음");
        }
        user.setPassword(passwordEncoder.encode(updatePasswordRequest.changePassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = this.getUserById(id);
        userRepository.delete(user);
    }
}


