package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class CategoriaVehiculoDaoImpl implements CategoriaVehiculoDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public CategoriaVehiculo crearCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
        sqlSession.insert("CategoriaVehiculoDao.crearCategoriaVehiculo", categoriaVehiculo);
        return categoriaVehiculo;
    }

    @Override
    public CategoriaVehiculo obtenerCategoriaVehiculo(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao.obtenerCategoriaVehiculo", id);
    }

    @Override
    public CategoriaVehiculo actualizarCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
        sqlSession.update("CategoriaVehiculoDao.actualizarCategoriaVehiculo", categoriaVehiculo);
        return categoriaVehiculo;
    }

    @Override
    public List<CategoriaVehiculo> listarCategoriasVehiculo() {
        return sqlSession.selectList("CategoriaVehiculoDao.listarCategoriasVehiculo");
    }

    @Override
    public void eliminarCategoriaVehiculo(BigDecimal id) {
        sqlSession.delete("CategoriaVehiculoDao.eliminarCategoriaVehiculo", id);
    }

    @Override
    public CategoriaVehiculo obtenerCategoriaVehiculoPorNombre(String vNombre) {
        return sqlSession.selectOne(
                "com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre",
                vNombre
        );
    }

    /*
    @Override
    public CategoriaVehiculo obtenerCategoriaVehiculoPorNombre(String vNombre) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre", vNombre);
    }

     */
}