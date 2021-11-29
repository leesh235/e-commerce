package com.ecommerce.server.domain;

import com.ecommerce.server.dto.AuthDto;
import lombok.*;

/*
* @Builder, @NoArgsConstructor, @AllArgsConstructor를 같이 사용해야
* mybatis에서 오류가 안생긴다.
* */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDomain {

    private String email;
    private String name;
    private String password;

//    public void patchData(AuthDto.signUpDto authDto){
//        this.email = authDto.getEmail();
//        this.name = authDto.getName();
//        this.password = authDto.getPassword();
//    }

}
