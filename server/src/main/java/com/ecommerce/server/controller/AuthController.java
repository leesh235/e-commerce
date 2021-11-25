package com.ecommerce.server.controller;

import com.ecommerce.server.dto.AuthDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthDto.signUpDto dto) throws Exception{

        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/login")
    public String logIn(@RequestBody String name){

        return "hello" + name;
    }

}
