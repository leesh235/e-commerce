package com.ecommerce.server.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class authController {

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("name") String name){
        System.out.println("gdgdgd");
        System.out.println(name);
        return "hello" + name;
    }

}
