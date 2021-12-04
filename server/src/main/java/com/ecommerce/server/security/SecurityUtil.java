package com.ecommerce.server.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//Security Context에 유저가 정보 저장 저장되는 시점
//request가 들어올 때 JwtFilter의 doFilter에서 저장
@Slf4j
public class SecurityUtil {

    private SecurityUtil(){}

    public static Long getCurrentMemberId(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || authentication.getName() == null){
            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
        }

        return Long.parseLong((authentication.getName()));

    }

}
