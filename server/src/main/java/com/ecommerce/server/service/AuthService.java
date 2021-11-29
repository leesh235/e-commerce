package com.ecommerce.server.service;

import com.ecommerce.server.domain.AuthDomain;
import com.ecommerce.server.dto.AuthDto;
import com.ecommerce.server.repository.mapper.MybatisAuthRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    MybatisAuthRepository mybatisAuthRepository;

    public List<AuthDomain> findAll(){
        final List<AuthDomain> authList = mybatisAuthRepository.SelectAll();
        System.out.println(authList);
        return authList;
    }

}
