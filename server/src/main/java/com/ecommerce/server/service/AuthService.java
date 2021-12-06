package com.ecommerce.server.service;

import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.common.jwt.TokenProvider;
import com.ecommerce.server.dao.AuthDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthDao authDao;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    public void signUp(AuthDto.signUpRequestDto dto){
//        AuthDomain authDomain = new AuthDomain(dto.getEmail(), dto.getName(), dto.getPassword(), "USER");
        authDao.Save(dto);
    }

    public AuthDto.tokenDto logIn(AuthDto.logInRequestDto dto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        Authentication authentication =
                authenticationManagerBuilder
                        .getObject()
                        .authenticate(authenticationToken);

        AuthDto.tokenDto user = tokenProvider.generateTokenDto(authentication);

        return user;
    }

}
