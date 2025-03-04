package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.CategoriaVehiculoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.CategoriaVehiculoDTO;
import com.qualitas.portal.fraudes.account.application.service.CategoriaVehiculoService;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaVehiculoServiceImpl implements CategoriaVehiculoService {

    @Autowired
    private CategoriaVehiculoDao categoriaVehiculoDao;

    @Autowired
    private CategoriaVehiculoConvertDTO categoriaVehiculoConvertDTO;

    @Override
    public CategoriaVehiculoDTO crearCategoriaVehiculo(CategoriaVehiculoDTO categoriaVehiculoDTO) {
        CategoriaVehiculo categoriaVehiculo = categoriaVehiculoConvertDTO.dtoToEntity(categoriaVehiculoDTO);
        CategoriaVehiculo categoriaVehiculoCreada = categoriaVehiculoDao.crearCategoriaVehiculo(categoriaVehiculo);
        return categoriaVehiculoConvertDTO.entityToDto(categoriaVehiculoCreada);
    }

    @Override
    public CategoriaVehiculoDTO obtenerCategoriaVehiculo(BigDecimal id) {
        CategoriaVehiculo categoriaVehiculo = categoriaVehiculoDao.obtenerCategoriaVehiculo(id);
        return categoriaVehiculoConvertDTO.entityToDto(categoriaVehiculo);
    }

    @Override
    public CategoriaVehiculoDTO actualizarCategoriaVehiculo(BigDecimal id, CategoriaVehiculoDTO categoriaVehiculoDTO) {
        CategoriaVehiculo categoriaVehiculo = categoriaVehiculoConvertDTO.dtoToEntity(categoriaVehiculoDTO);
        categoriaVehiculo.setlCategoriaVehiculoId(id);
        CategoriaVehiculo categoriaVehiculoActualizada = categoriaVehiculoDao.actualizarCategoriaVehiculo(categoriaVehiculo);
        return categoriaVehiculoConvertDTO.entityToDto(categoriaVehiculoActualizada);
    }

    @Override
    public List<CategoriaVehiculoDTO> listarCategoriasVehiculo() {
        return categoriaVehiculoDao.listarCategoriasVehiculo().stream()
                .map(categoriaVehiculoConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarCategoriaVehiculo(BigDecimal id) {
        categoriaVehiculoDao.eliminarCategoriaVehiculo(id);
    }
}