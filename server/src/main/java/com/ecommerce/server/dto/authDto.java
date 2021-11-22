package com.ecommerce.server.dto;

import lombok.Getter;
import lombok.Setter;

public class authDto {

    @Getter
    @Setter
    public static class signUpDto{
        private String email;
        private String name;
        private String password;
    }

    @Getter
    @Setter
    public static class logInDto{
        private String email;
        private String password;
    }

}
