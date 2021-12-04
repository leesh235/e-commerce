package com.ecommerce.server.dto;

import com.ecommerce.server.domain.AuthDomain;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

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
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class logInDto{
        private String email;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class tokenDto{
        private String grantType;
        private String accessToken;
        private String refreshToken;
        private long accessTokenExpiresIn;
    }

}
