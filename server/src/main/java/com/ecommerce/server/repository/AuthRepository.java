package com.ecommerce.server.repository;

import com.ecommerce.server.domain.AuthDomain;

import java.util.List;

public interface AuthRepository {

    List<AuthDomain> SelectAll();
    AuthDomain Select();
    AuthDomain Save(AuthDomain authDomain);
    AuthDomain Modify(AuthDomain authDomain);
    AuthDomain Delete(AuthDomain authDomain);

}
