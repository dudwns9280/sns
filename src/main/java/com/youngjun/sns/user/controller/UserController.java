package com.youngjun.sns.user.controller;

import com.youngjun.sns.user.dto.request.CreateUserRequest;
import com.youngjun.sns.user.dto.request.UpdatePasswordRequest;
import com.youngjun.sns.user.dto.request.UpdateUserInfoRequest;
import com.youngjun.sns.user.dto.response.UserResponse;
import com.youngjun.sns.user.entity.User;
import com.youngjun.sns.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new UserResponse(user));
    }
    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Validated CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody @Validated UpdateUserInfoRequest updateUserInfoRequest){
        User user = userService.updateUserInfo(id, updateUserInfoRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @PatchMapping("/password")
    public ResponseEntity<UserResponse> updatePassword(@RequestBody @Validated UpdatePasswordRequest updatePasswordRequest){
        User user = userService.updatePassword(updatePasswordRequest);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Success");
    }
}
