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

    public boolean modifyProfile(UserDto.modifyProfileDto dto){
        UserDto.modifyProfileDto user = UserDto.modifyProfileDto.builder()
                .userId(SecurityUtil.getCurrentMemberId())
                .name(dto.getName())
                .emailAd(dto.isEmailAd())
                .phoneAd(dto.isPhoneAd())
                .build();
        if(userDao.modifyUser(user) > 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyPassword(UserDto.modifyPassword dto){
        UserDto.modifyPassword user = UserDto.modifyPassword.builder()
                .userId(SecurityUtil.getCurrentMemberId())
                .currentPassword(dto.getCurrentPassword())
                .nextPassword(dto.getNextPassword())
                .confirmPassword(dto.getConfirmPassword())
                .build();
        if(dto.getNextPassword().equals(dto.getConfirmPassword())){
            if(userDao.modifyPassword(user) > 0) {
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
