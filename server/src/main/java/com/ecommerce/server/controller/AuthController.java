package com.ecommerce.server.controller;

import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    AuthService authService = new AuthService();

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthDto.signUpDto dto) throws Exception{
        authService.signUp(dto);
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody AuthDto.logInDto dto) throws Exception{
        return ResponseEntity.ok().body(authService.logIn(dto));
    }

    @GetMapping("/test")
    public String test() throws Exception{
        return "test";
    }

}
