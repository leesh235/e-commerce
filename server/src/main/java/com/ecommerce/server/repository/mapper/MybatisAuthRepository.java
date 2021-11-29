package com.ecommerce.server.repository.mapper;

import com.ecommerce.server.domain.AuthDomain;
import com.ecommerce.server.repository.AuthRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*  mabatis용 repository
*  mapper.xml과 연동되는 곳, 주로 interface로 구성되며 DAO라고함(repository로도 사용가능)
* */
@Mapper
@Repository
public interface MybatisAuthRepository extends AuthRepository {
    List<AuthDomain> SelectAll();
    AuthDomain Select();
    AuthDomain Save(AuthDomain authDomain);
    AuthDomain Modify(AuthDomain authDomain);
    AuthDomain Delete(AuthDomain authDomain);

}
