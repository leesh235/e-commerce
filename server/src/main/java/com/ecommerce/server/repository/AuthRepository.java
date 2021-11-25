package com.ecommerce.server.repository;

import com.ecommerce.server.domain.AuthDomain;

public interface AuthRepository {

    AuthDomain Save(AuthDomain authDomain);
    AuthDomain modify(AuthDomain authDomain);
    AuthDomain delete(AuthDomain authDomain);

}
