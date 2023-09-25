package com.youngjun.sns.user.service;

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
}


