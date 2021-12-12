package com.ecommerce.server.service;

import com.ecommerce.server.common.security.SecurityUtil;
import com.ecommerce.server.dao.UserDao;
import com.ecommerce.server.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public UserDto.myProfileResponseDto getMyProfile(){
        return userDao.findUser(SecurityUtil.getCurrentMemberId());
    }

}
