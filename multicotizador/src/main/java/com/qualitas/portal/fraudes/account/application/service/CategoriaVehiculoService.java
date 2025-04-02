package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.CategoriaVehiculoDTO;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;

import java.math.BigDecimal;
import java.util.List;

public interface CategoriaVehiculoService {
    CategoriaVehiculoDTO crearCategoriaVehiculo(CategoriaVehiculoDTO categoriaVehiculoDTO);
    CategoriaVehiculoDTO obtenerCategoriaVehiculo(BigDecimal id);
    CategoriaVehiculoDTO actualizarCategoriaVehiculo(BigDecimal id, CategoriaVehiculoDTO categoriaVehiculoDTO);
    List<CategoriaVehiculoDTO> listarCategoriasVehiculo();
    void eliminarCategoriaVehiculo(BigDecimal id);
    CategoriaVehiculo obtenerCategoriaVehiculoPorNombre(String vNombre);
}