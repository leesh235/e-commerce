package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AuthDto {

    @Getter
    @AllArgsConstructor
    public static class signUpDto{
        private String email;
        private String name;
        private String password;
    }

    @Getter
    public static class logInDto{
        private String email;
        private String password;
    }

}
