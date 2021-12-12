package com.ecommerce.server.controller;

import com.ecommerce.server.dto.UserDto;
import com.ecommerce.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<?> myProfile() throws Exception{
        return ResponseEntity.ok().body(userService.getMyProfile());
    }

}
