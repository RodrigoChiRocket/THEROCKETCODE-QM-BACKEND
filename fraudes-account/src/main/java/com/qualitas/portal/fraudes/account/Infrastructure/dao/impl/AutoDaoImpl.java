package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao;
import com.qualitas.portal.fraudes.account.domain.model.Auto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AutoDaoImpl implements AutoDao {

    private final SqlSession sqlSession;

    @Autowired
    public AutoDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Auto crearAuto(Auto auto) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao.crearAuto", auto);
        return auto;
    }

    @Override
    public Auto obtenerAuto(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao.obtenerAuto", id);
    }

    @Override
    public Auto actualizarAuto(Auto auto) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao.actualizarAuto", auto);
        return auto;
    }

    @Override
    public List<Auto> listarAuto() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao.listarAuto");
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao.eliminarAuto", id);
    }
}
