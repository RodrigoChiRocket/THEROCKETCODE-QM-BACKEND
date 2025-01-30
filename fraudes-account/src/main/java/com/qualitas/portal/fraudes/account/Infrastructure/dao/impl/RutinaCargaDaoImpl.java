package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RutinaCargaDaoImpl implements RutinaCargaDao {

    private final SqlSession sqlSession;

    @Autowired
    public RutinaCargaDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public RutinaCarga crearRutina(RutinaCarga rutinaCarga) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.crearRutinaCarga", rutinaCarga);
        return rutinaCarga;
    }

    @Override
    public RutinaCarga obtenerRutina(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.obtenerRutinaCarga", id);
    }

    @Override
    public RutinaCarga actualizarRutina(RutinaCarga rutinaCarga) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.actualizarRutinaCarga", rutinaCarga);
        return rutinaCarga;
    }

    @Override
    public List<RutinaCarga> listarRutinas() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.listarRutinaCarga");
    }

    @Override
    public void eliminarRutina(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.eliminarRutinaCarga", id);
    }
}
