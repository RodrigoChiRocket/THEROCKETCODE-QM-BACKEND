package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao;
import com.qualitas.portal.fraudes.account.domain.model.Uso;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class UsoDaoImpl implements UsoDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Uso crearUso(Uso uso) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.crearUso", uso);
        return uso;
    }

    @Override
    public Uso obtenerUso(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.obtenerUso", id);
    }

    @Override
    public Uso actualizarUso(Uso uso) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.actualizarUso", uso);
        return uso;
    }

    @Override
    public List<Uso> listarUsos() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.listarUsos");
    }

    @Override
    public void eliminarUso(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.eliminarUso", id);
    }

    @Override
    public Uso obtenerUsoPorNombre(String vNombre) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao.obtenerUsoPorNombre", vNombre);
    }
}