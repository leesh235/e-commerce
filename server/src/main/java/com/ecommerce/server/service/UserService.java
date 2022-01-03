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

    public UserDto.profileDto getProfile(){
        return userDao.findUser(SecurityUtil.getCurrentMemberId());
    }

    public boolean confirmUser(UserDto.confirmUserDto dto){
        UserDto.confirmUserDto user = UserDto.confirmUserDto.builder()
                .userId(SecurityUtil.getCurrentMemberId())
                .password(dto.getPassword())
                .build();

        if(userDao.confirmPassword(user) == SecurityUtil.getCurrentMemberId()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyProfile(UserDto.modifyProfileDto dto){
        UserDto.modifyProfileDto user = UserDto.modifyProfileDto.builder()
                .userId(SecurityUtil.getCurrentMemberId())
                .name(dto.getName())
                .emailAd(dto.isEmailAd())
                .phoneAd(dto.isPhoneAd())
                .password(dto.getPassword())
                .confirmPassword(dto.getConfirmPassword())
                .build();

        if(dto.getPassword().equals(dto.getConfirmPassword())){
            if(userDao.modifyUser(user) > 0) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean unregister(UserDto.unregisterDto dto){
        UserDto.unregisterDto user = UserDto.unregisterDto.builder()
                .userId(SecurityUtil.getCurrentMemberId())
                .password(dto.getPassword())
                .build();

        if(userDao.deleteUser(user) > 0) {
            return true;
        }else{
            return false;
        }
    }

}
