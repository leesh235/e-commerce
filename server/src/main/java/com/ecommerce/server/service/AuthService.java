package com.ecommerce.server.service;

import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.common.jwt.TokenProvider;
import com.ecommerce.server.dao.AuthDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthDao authDao;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    public void signUp(AuthDto.signUpRequestDto dto){
        authDao.save(dto);
        authDao.saveAuthority(dto.getUserId());
    }

    public AuthDto.tokenDto logIn(AuthDto.logInRequestDto dto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        Authentication authentication =
                authenticationManagerBuilder
                        .getObject()
                        .authenticate(authenticationToken);

        System.out.println(authentication);

        AuthDto.tokenDto user = tokenProvider.generateTokenDto(authentication);

        return user;
    }

}
