package com.ecommerce.server.dto;

import com.ecommerce.server.domain.AuthDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AuthDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class signUpDto{
        private String email;
        private String name;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class logInDto{
        private String email;
        private String password;
    }

    @Getter
    public static class userLogInDto{
        private String email;
        private String name;
        public userLogInDto(AuthDomain authDomain){
            this.email = authDomain.getEmail();
            this.name = authDomain.getName();
        }
    }

}
