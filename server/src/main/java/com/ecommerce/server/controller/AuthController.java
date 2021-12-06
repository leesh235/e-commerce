package com.ecommerce.server.controller;

import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthDto.signUpRequestDto dto) throws Exception{
        authService.signUp(dto);
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody AuthDto.logInRequestDto dto) throws Exception{
        return ResponseEntity.ok().body(authService.logIn(dto));
    }

}
