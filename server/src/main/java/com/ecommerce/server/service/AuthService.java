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

    public boolean checkEmail(AuthDto.emailDto dto){
        if(!authDao.findEmail(dto.getEmail()).isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public void checkPhone(AuthDto.phoneDto dto){
        //핸드폰인증 로직
    }

    public boolean signUpConsumer(AuthDto.consumerDto dto){
        if(!authDao.findEmail(dto.getEmail()).isPresent()) {
            authDao.saveConsumer(dto);
            authDao.saveAuthority(dto.getUserId());
            return true;
        }else{
            return false;
        }
    }

    public boolean signUpSeller(AuthDto.sellerDto dto){
        if(!authDao.findEmail(dto.getEmail()).isPresent()) {
            authDao.saveSeller(dto);
            authDao.saveAuthority(dto.getUserId());
            return true;
        }else{
            return false;
        }
    }

    public AuthDto.tokenDto logIn(AuthDto.logInRequestDto dto) throws UsernameNotFoundException{
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
