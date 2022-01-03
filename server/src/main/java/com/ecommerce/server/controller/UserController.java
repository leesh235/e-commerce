package com.ecommerce.server.controller;

import com.ecommerce.server.dto.UserDto;
import com.ecommerce.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<?> profile() throws Exception{
        return ResponseEntity.ok().body(userService.getProfile());
    }

    @PostMapping("/modify-profile")
    public ResponseEntity<?> modifyProfile(@RequestBody UserDto.modifyProfileDto dto) throws Exception{
        return ResponseEntity.ok().body(userService.modifyProfile(dto));
    }

    @PostMapping("/confirm-user")
    public ResponseEntity<?> modifyProfile(@RequestBody UserDto.confirmUser dto) throws Exception{
        return ResponseEntity.ok().body(userService.confirmUser(dto));
    }

    @PostMapping("/unregister")
    public ResponseEntity<?> unregister(@RequestBody UserDto.unregisterDto dto) throws Exception{
        return ResponseEntity.ok().body(userService.unregister(dto));
    }

}
