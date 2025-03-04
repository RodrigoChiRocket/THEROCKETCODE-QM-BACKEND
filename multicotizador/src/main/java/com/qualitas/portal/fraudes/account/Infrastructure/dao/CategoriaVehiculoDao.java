package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;
import java.math.BigDecimal;
import java.util.List;

public interface CategoriaVehiculoDao {
    CategoriaVehiculo crearCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo);
    CategoriaVehiculo obtenerCategoriaVehiculo(BigDecimal id);
    CategoriaVehiculo actualizarCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo);
    List<CategoriaVehiculo> listarCategoriasVehiculo();
    void eliminarCategoriaVehiculo(BigDecimal id);
}