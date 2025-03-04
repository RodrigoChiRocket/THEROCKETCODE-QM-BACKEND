package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoMarcaDao;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class AutoMarcaDaoImpl implements AutoMarcaDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public AutoMarca crearAutoMarca(AutoMarca autoMarca) {
        sqlSession.insert("AutoMarcaDao.crearAutoMarca", autoMarca);
        return autoMarca;
    }

    @Override
    public AutoMarca obtenerAutoMarca(BigDecimal id) {
        return sqlSession.selectOne("AutoMarcaDao.obtenerAutoMarca", id);
    }

    @Override
    public AutoMarca actualizarAutoMarca(AutoMarca autoMarca) {
        sqlSession.update("AutoMarcaDao.actualizarAutoMarca", autoMarca);
        return autoMarca;
    }

    @Override
    public List<AutoMarca> listarAutoMarcas() {
        return sqlSession.selectList("AutoMarcaDao.listarAutoMarcas");
    }

    @Override
    public void eliminarAutoMarca(BigDecimal id) {
        sqlSession.delete("AutoMarcaDao.eliminarAutoMarca", id);
    }
}