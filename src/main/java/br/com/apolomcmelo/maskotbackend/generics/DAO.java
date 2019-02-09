package br.com.apolomcmelo.maskotbackend.generics;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public abstract class DAO {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
}