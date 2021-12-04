package com.ecommerce.server.service;

import com.ecommerce.server.domain.AuthDomain;
import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.jwt.TokenProvider;
import com.ecommerce.server.repository.mapper.MybatisAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MybatisAuthRepository mybatisAuthRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    public void signUp(AuthDto.signUpDto dto){
        AuthDomain authDomain = new AuthDomain(dto.getEmail(), dto.getName(), dto.getPassword(), "USER");
        mybatisAuthRepository.Save(authDomain);
    }

    public AuthDto.tokenDto logIn(AuthDto.logInDto dto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        Authentication authentication =
                authenticationManagerBuilder
                        .getObject()
                        .authenticate(authenticationToken);

        AuthDto.tokenDto user = tokenProvider.generateTokenDto(authentication);

        return user;
    }

}
