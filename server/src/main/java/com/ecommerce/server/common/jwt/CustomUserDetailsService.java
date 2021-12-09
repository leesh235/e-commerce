package com.ecommerce.server.common.jwt;

import com.ecommerce.server.dao.AuthDao;
import com.ecommerce.server.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthDao authDao;

    //db에서 존재여부를 확인 후 userdetails 객체로 반환
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return authDao.findEmail(email)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(email + "-> 데이터베이스에서 찾을 수 없습니다."));
    }

    //userdetails 객체 생성
    private UserDetails createUserDetails(AuthDto.logInResponseDto dto){
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authDao.findAuthority(dto.getUserId()).getAuthority());

        User user = new User(
                String.valueOf(dto.getUserId()),
                //security version up에 따라 패스워드 앞에 "{noop}"을 붙여줘야한다
                "{noop}" + dto.getPassword(),
                Collections.singleton(grantedAuthority));

        return user;
    }

}
