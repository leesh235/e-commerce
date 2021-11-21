package com.ecommerce.server.dto;

import lombok.Getter;

public class authDto {

    @Getter
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
