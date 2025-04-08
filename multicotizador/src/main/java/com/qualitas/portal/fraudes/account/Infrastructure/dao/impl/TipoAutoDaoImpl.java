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

    @Autowired
    private SqlSession sqlSession;

    @Override
    public TipoAuto crearTipoAuto(TipoAuto tipoAuto) {
        sqlSession.insert("TipoAutoDao.crearTipoAuto", tipoAuto);
        return tipoAuto;
    }

    @Override
    public TipoAuto obtenerTipoAuto(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao.obtenerTipoAuto", id);
    }

    @Override
    public TipoAuto actualizarTipoAuto(TipoAuto tipoAuto) {
        sqlSession.update("TipoAutoDao.actualizarTipoAuto", tipoAuto);
        return tipoAuto;
    }

    @Override
    public List<TipoAuto> listarTiposAuto() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.git TipoAutoDao.listarTiposAuto");
    }

    @Override
    public void eliminarTipoAuto(BigDecimal id) {
        sqlSession.delete("TipoAutoDao.eliminarTipoAuto", id);
    }



    @Override
    public TipoAuto obtenerTipoAutoPorNombre(String vNombre) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao.obtenerTipoAutoPorNombre", vNombre);
    }


}