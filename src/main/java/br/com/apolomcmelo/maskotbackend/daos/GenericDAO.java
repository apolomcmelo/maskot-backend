package br.com.apolomcmelo.maskotbackend.daos;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public abstract class GenericDAO {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
}