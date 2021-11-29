package com.ecommerce.server.controller;

import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.service.AuthService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    AuthService authService = new AuthService();

    @GetMapping("/signup")
    public ResponseEntity<?> signUp() throws Exception{

        return ResponseEntity.ok().body(authService.findAll());
    }

    @PostMapping("/login")
    public String logIn(@RequestBody String name){

        return "hello" + name;
    }

}
