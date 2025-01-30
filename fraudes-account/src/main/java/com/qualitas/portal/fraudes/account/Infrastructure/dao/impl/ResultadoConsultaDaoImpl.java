package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoConsulta;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ResultadoConsultaDaoImpl implements ResultadoConsultaDao {

    private final SqlSession sqlSession;

    @Autowired
    public ResultadoConsultaDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public ResultadoConsulta crearResultadoConsulta(ResultadoConsulta resultadoConsulta) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao.crearResultadoConsulta", resultadoConsulta);
        return resultadoConsulta;
    }

    @Override
    public ResultadoConsulta obtenerResultadoConsulta(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao.obtenerResultadoConsulta", id);
    }

    @Override
    public ResultadoConsulta actualizarResultadoConsulta(ResultadoConsulta resultadoConsulta) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao.actualizarResultadoConsulta", resultadoConsulta);
        return resultadoConsulta;
    }

    @Override
    public List<ResultadoConsulta> listarResultadoConsulta() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao.listarResultadoConsulta");
    }

    @Override
    public void eliminarResultadoConsulta(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao.eliminarResultadoConsulta", id);
    }
}
