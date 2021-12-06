package com.ecommerce.server.dao;

import com.ecommerce.server.dto.AuthDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
*  mabatis용 repository
*  mapper.xml과 연동되는 곳, 주로 interface로 구성되며 DAO라고함(repository로도 사용가능)
* */
@Mapper
@Repository
public interface AuthDao {

    //아이디 중복 검증
    Optional<AuthDto.logInResponseDto> Select(String email);

    //회원가입
    void Save(AuthDto.signUpRequestDto dto);

}
