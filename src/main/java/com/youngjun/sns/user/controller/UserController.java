package com.youngjun.sns.user.controller;

import com.youngjun.sns.user.dto.response.GetUserResponse;
import com.youngjun.sns.user.entity.User;
import com.youngjun.sns.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new GetUserResponse(user));
    }
}
