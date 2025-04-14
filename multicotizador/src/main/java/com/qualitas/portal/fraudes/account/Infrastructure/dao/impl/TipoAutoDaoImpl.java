package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class TipoAutoDaoImpl implements TipoAutoDao {

    private static final String NAMESPACE = "com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public TipoAuto crearTipoAuto(TipoAuto tipoAuto) {
        sqlSession.insert(NAMESPACE + "crearTipoAuto", tipoAuto);
        return tipoAuto;
    }

    @Override
    public TipoAuto obtenerTipoAuto(BigDecimal id) {
        return sqlSession.selectOne(NAMESPACE + "obtenerTipoAuto", id);
    }

    @Override
    public TipoAuto actualizarTipoAuto(TipoAuto tipoAuto) {
        sqlSession.update(NAMESPACE + "actualizarTipoAuto", tipoAuto);
        return tipoAuto;
    }

    @Override
    public List<TipoAuto> listarTiposAuto() {
        return sqlSession.selectList(NAMESPACE + "listarTiposAuto");
    }

    @Override
    public void eliminarTipoAuto(BigDecimal id) {
        sqlSession.delete(NAMESPACE + "eliminarTipoAuto", id);
    }

    @Override
    public TipoAuto obtenerTipoAutoPorNombre(String vNombre) {
        return sqlSession.selectOne(NAMESPACE + "obtenerTipoAutoPorNombre", vNombre);
    }
}