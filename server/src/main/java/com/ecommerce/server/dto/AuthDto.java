package com.ecommerce.server.dto;

import com.ecommerce.server.domain.AuthDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AuthDto {

    @Getter
    public static class signUpDto{
        private String email;
        private String name;
        private String password;

        public signUpDto(AuthDomain authDomain){
            this.email = authDomain.getEmail();
            this.name = authDomain.getName();
            this.password = authDomain.getPassword();
        }
    }

    @Getter
    public static class logInDto{
        private String email;
        private String password;
    }

}
