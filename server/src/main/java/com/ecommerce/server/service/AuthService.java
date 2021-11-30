package com.ecommerce.server.service;

import com.ecommerce.server.domain.AuthDomain;
import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.repository.mapper.MybatisAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    MybatisAuthRepository mybatisAuthRepository;

    public List<AuthDomain> findAll(){
        final List<AuthDomain> authList = mybatisAuthRepository.SelectAll();

        return authList;
    }

    public void signUp(AuthDto.signUpDto dto){
        AuthDomain authDomain = new AuthDomain();
        authDomain.patchSignUpData(dto);
        mybatisAuthRepository.Save(authDomain);
    }

    public AuthDto.userLogInDto logIn(AuthDto.logInDto dto){
        AuthDomain authDomain = new AuthDomain();
        authDomain.patchLogInData(dto);
        mybatisAuthRepository.Select(authDomain);
        AuthDto.userLogInDto user = new AuthDto.userLogInDto(mybatisAuthRepository.Select(authDomain));
        return user;
    }

}
