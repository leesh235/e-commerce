package com.ecommerce.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthDomain {

    private String email;
    private String name;
    private String password;

}
