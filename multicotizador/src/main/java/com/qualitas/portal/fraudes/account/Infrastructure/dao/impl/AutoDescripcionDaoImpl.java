package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AutoDescripcionDaoImpl implements AutoDescripcionDao {

    private final SqlSession sqlSession;

    @Autowired
    public AutoDescripcionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public AutoDescripcion crearAuto(AutoDescripcion autoDescripcion) {
        // Asegúrate de que el nombre del método en MyBatis coincida con el nombre aquí
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao.crearAutoDescripcion", autoDescripcion);
        return autoDescripcion;
    }

    @Override
    public AutoDescripcion obtenerAuto(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao.obtenerAutoDescripcion", id);
    }

    @Override
    public AutoDescripcion actualizarAuto(AutoDescripcion autoDescripcion) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao.actualizarAutoDescripcion", autoDescripcion);
        return autoDescripcion;
    }

    @Override
    public List<AutoDescripcion> listarAuto() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao.listarAutoDescripcion");
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao.eliminarAutoDescripcion", id);
    }
}
