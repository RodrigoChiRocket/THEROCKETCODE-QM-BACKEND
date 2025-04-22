package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;


import com.qualitas.portal.fraudes.account.Infrastructure.dao.CotizacionDao;
import com.qualitas.portal.fraudes.account.domain.model.Cotizacion;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CotizacionDaoImpl implements CotizacionDao {

    private final SqlSession sqlSession;

    @Autowired
    public CotizacionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Cotizacion crearCotizacion(Cotizacion cotizacion) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.crearCotizacion", cotizacion);
        return cotizacion;
    }
    public Cotizacion crearCotizacionCatalogo(Cotizacion cotizacion) {
        cotizacion.setbCatalogoDato(1);
        cotizacion.setiTipoSeguroClave(new BigDecimal(1));
        sqlSession.insert("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.crearCotizacionCatalogo", cotizacion);
        return cotizacion;
    }

    @Override
    public Cotizacion obtenerCotizacionPorId(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.obtenerCotizacionPorId", id);
    }

    @Override
    public Cotizacion actualizarCotizacion(Cotizacion cotizacion) {
        sqlSession.update("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.actualizarCotizacion", cotizacion);
        return cotizacion;
    }

    @Override
    public Cotizacion actualizarCotizacionCatalogo(Cotizacion cotizacion) {
        // Asegurar que mantenga el flag de catálogo
        cotizacion.setbCatalogoDato(1);
        sqlSession.update("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.actualizarCotizacion", cotizacion);
        return cotizacion;
    }

    @Override
    public void eliminarCotizacion(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.eliminarCotizacion", id);
    }

    @Override
    public List<Cotizacion> listarTodasLasCotizaciones() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.listarTodasLasCotizaciones");
    }




    @Override
    public List<Cotizacion> listarCotizacionesSinPaginado() {
        return sqlSession.selectList(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.listarCotizacionesSinPaginado");
    }

    @Override
    public List<Cotizacion> listarCotizacionesPaginadas(int offset, int limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", limit);
        return sqlSession.selectList(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.listarCotizacionesPaginadas",
                params
        );
    }

    @Override
    public int contarTotalCotizaciones() {
        return sqlSession.selectOne(
                "com.qualitas.portal.fraudes.account.infrastructure.dao.CotizacionDao.contarTotalCotizaciones"
        );
    }
}