package com.ecommerce.server.api.auth;

import com.ecommerce.server.dto.authDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class authController {

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody authDto.signUpDto dto) throws Exception{

        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/login")
    public String logIn(@RequestBody String name){

        return "hello" + name;
    }

}
