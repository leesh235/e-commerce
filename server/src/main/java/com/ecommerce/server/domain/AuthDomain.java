package com.ecommerce.server.domain;

import com.ecommerce.server.dto.AuthDto;
import lombok.*;

/*
* @Builder, @NoArgsConstructor, @AllArgsConstructor를 같이 사용해야
* mybatis에서 오류가 안생긴다.
* */

@Getter
@NoArgsConstructor
public class AuthDomain {

    private Long userId;
    private String email;
    private String name;
    private String password;
    private String authority;

    @Builder
    public AuthDomain(String email, String name, String password, String authority){
        this.email = email != "" ? email : "";
        this.name = name != "" ? name : "";
        this.password = password != "" ? password : "";
        this.authority = authority != "" ? authority : "";
    }

}
