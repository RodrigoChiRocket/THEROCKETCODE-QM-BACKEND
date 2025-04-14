package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void actualizarDatosObtenidos(BigDecimal id, Integer nuevosDatos) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        parametros.put("iDatosObtenidos", nuevosDatos);

        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.actualizarDatosObtenidos", parametros);



    }

    @Override
    public void actualizarProgramacion(BigDecimal id, LocalDateTime nuevaProgramacion) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        parametros.put("dProgramacion", nuevaProgramacion);

        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.actualizarProgramacion", parametros);
    }
    @Override
    public void actualizarHabilitado(BigDecimal id, Integer habilitado) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        parametros.put("bHabilitado", habilitado);

        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao.actualizarHabilitado", parametros);
    }
}
