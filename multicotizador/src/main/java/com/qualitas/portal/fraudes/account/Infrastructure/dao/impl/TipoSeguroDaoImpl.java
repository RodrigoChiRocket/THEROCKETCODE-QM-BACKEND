package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoSeguroDao;
import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class TipoSeguroDaoImpl implements TipoSeguroDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public TipoSeguro crearTipoSeguro(TipoSeguro tipoSeguro) {
        sqlSession.insert("TipoSeguroDao.crearTipoSeguro", tipoSeguro);
        return tipoSeguro;
    }

    @Override
    public TipoSeguro obtenerTipoSeguro(BigDecimal id) {
        return sqlSession.selectOne("TipoSeguroDao.obtenerTipoSeguro", id);
    }

    @Override
    public TipoSeguro actualizarTipoSeguro(TipoSeguro tipoSeguro) {
        sqlSession.update("TipoSeguroDao.actualizarTipoSeguro", tipoSeguro);
        return tipoSeguro;
    }

    @Override
    public List<TipoSeguro> listarTiposSeguro() {
        return sqlSession.selectList("TipoSeguroDao.listarTiposSeguro");
    }

    @Override
    public void eliminarTipoSeguro(BigDecimal id) {
        sqlSession.delete("TipoSeguroDao.eliminarTipoSeguro", id);
    }
}