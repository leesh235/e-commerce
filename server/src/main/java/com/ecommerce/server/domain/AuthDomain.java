package com.ecommerce.server.domain;

import com.ecommerce.server.dto.AuthDto;
import lombok.*;

/*
* @Builder, @NoArgsConstructor, @AllArgsConstructor를 같이 사용해야
* mybatis에서 오류가 안생긴다.
* */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDomain {

    private String email;
    private String name;
    private String password;

    public void patchSignUpData(AuthDto.signUpDto dto){
        this.email = dto.getEmail() != "" ? dto.getEmail() : this.email;
        this.name = dto.getName() != "" ? dto.getName() : this.name;
        this.password = dto.getPassword() != "" ? dto.getPassword() : this.password;
    }

    public void patchLogInData(AuthDto.logInDto dto){
        this.email = dto.getEmail() != "" ? dto.getEmail() : this.email;
        this.password = dto.getPassword() != "" ? dto.getPassword() : this.password;
    }

}
