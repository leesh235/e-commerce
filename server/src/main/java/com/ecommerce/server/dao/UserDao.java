package com.ecommerce.server.dao;

import com.ecommerce.server.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    //유저 정보 가져오기
    UserDto.profileDto findUser(long userId);

    //유저 정보 변경
    int modifyUser(UserDto.modifyProfileDto dto);

    //유저 정보 변경
    int modifyPassword(UserDto.modifyPassword dto);

    //회원탈퇴 **다른 테이블 fk에 cascade설정 할 것
    int deleteUser(UserDto.unregisterDto dto);

}
