package com.ecommerce.server.repository.mapper;

import com.ecommerce.server.domain.AuthDomain;
import com.ecommerce.server.repository.AuthRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class MybatisAuthRepository implements AuthRepository {

    @Override
    public AuthDomain Save(AuthDomain authDomain) {
        return null;
    }

    @Override
    public AuthDomain modify(AuthDomain authDomain) {
        return null;
    }

    @Override
    public AuthDomain delete(AuthDomain authDomain) {
        return null;
    }

}
