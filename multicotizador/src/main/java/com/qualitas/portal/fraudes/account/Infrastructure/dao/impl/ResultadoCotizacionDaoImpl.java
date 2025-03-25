package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoCotizacionDao;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResultadoCotizacionDaoImpl implements ResultadoCotizacionDao {

    private final SqlSession sqlSession;

    @Autowired
    public ResultadoCotizacionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public ResultadoCotizacion crearResultadoCotizacion(ResultadoCotizacion resultadoCotizacion) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.crearResultadoCotizacion", resultadoCotizacion);
        return resultadoCotizacion;
    }

    @Override
    public ResultadoCotizacion obtenerResultadoCotizacion(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.obtenerResultadoCotizacion", id);
    }

    @Override
    public ResultadoCotizacion actualizarResultadoCotizacion(ResultadoCotizacion resultadoCotizacion) {
        sqlSession.update("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.actualizarResultadoCotizacion", resultadoCotizacion);
        return resultadoCotizacion;
    }

    @Override
    public List<ResultadoCotizacion> listarResultadosCotizacion() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.listarResultadosCotizacion");
    }

    @Override
    public void eliminarResultadoCotizacion(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.eliminarResultadoCotizacion", id);
    }


    @Override
    public List<ResultadoCotizacion> obtenerResultadoPorCotizacionClave(BigDecimal cotizacionClave) {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.obtenerResultadoPorCotizacionClave", cotizacionClave);
    }

    @Override
    public List<ResultadoCotizacion> buscarPorNombreSeguroYCotizacionClave(String nombreSeguro, BigDecimal cotizacionClave) {
        // Crear un mapa para los parámetros
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombreSeguro", nombreSeguro);
        parametros.put("cotizacionClave", cotizacionClave);

        // Ejecutar la consulta
        return sqlSession.selectList(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.buscarPorNombreSeguroYCotizacionClave",
                parametros
        );
    }

    @Override
    public List<String> obtenerNombresSegurosUnicos() {
        return sqlSession.selectList(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.obtenerNombresSegurosUnicos"
        );
    }

    @Override
    public boolean verificarEstadoCotizacion(BigDecimal cotizacionClave) {
        return sqlSession.selectOne(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.verificarEstadoCotizacion",
                cotizacionClave
        );
    }


    @Override
    public List<ResultadoCotizacion> filtrarResultadosCotizacion(Map<String, Object> parametros) {
        return sqlSession.selectList(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.ResultadoCotizacionDao.filtrarResultadosCotizacion",
                parametros
        );
    }
}