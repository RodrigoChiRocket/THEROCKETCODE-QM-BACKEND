package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AutoModeloDaoImpl implements AutoModeloDao {

    private final SqlSession sqlSession;

    @Autowired
    public AutoModeloDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public AutoModelo crearAuto(AutoModelo autoModelo) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao.crearAutoModelo", autoModelo);
        return autoModelo;
    }

    @Override
    public AutoModelo obtenerAuto(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao.obtenerAutoModelo", id);
    }

    @Override
    public AutoModelo actualizarAuto(AutoModelo autoModelo) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao.actualizarAutoModelo", autoModelo);
        return autoModelo;
    }

    @Override
    public List<AutoModelo> listarAuto() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao.listarAutoModelo");
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao.eliminarAutoModelo", id);
    }
}
