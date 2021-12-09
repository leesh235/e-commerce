package com.ecommerce.server.dao;

import com.ecommerce.server.dto.AuthDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
*  mabatis용 repository
*  mapper.xml과 연동되는 곳, 주로 interface로 구성되며 DAO라고함(repository로도 사용가능)
* */
@Mapper
@Repository
public interface AuthDao {

    //회원가입
    int save(AuthDto.signUpRequestDto dto);

    //유저 권한 저장
    int saveAuthority(long userId);

    //아이디 중복 검증
    Optional<AuthDto.logInResponseDto> findEmail(String email);

    //유저 권한 검색
    AuthDto.userAuthority findAuthority(long userId);

}
