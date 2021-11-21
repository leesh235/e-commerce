package com.ecommerce.server.api.auth;

import com.ecommerce.server.dto.authDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class authController {

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<?> signUp(@RequestBody authDto.signUpDto dto){
        System.out.println(dto);
        return ResponseEntity.ok().body("");
    }

    @PostMapping("/login")
    @ResponseBody
    public String logIn(@RequestBody String name){

        return "hello" + name;
    }

}
