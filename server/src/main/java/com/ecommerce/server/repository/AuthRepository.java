package com.ecommerce.server.repository;

import com.ecommerce.server.domain.AuthDomain;

import java.util.List;
import java.util.Optional;

public interface AuthRepository {

    List<AuthDomain> SelectAll();
    Optional<AuthDomain> Select(String email);
    void Save(AuthDomain authDomain);
    AuthDomain Modify(AuthDomain authDomain);
    AuthDomain Delete(AuthDomain authDomain);

}
