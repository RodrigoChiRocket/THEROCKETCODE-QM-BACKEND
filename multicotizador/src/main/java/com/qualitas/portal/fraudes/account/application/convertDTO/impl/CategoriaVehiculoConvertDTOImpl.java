package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.CategoriaVehiculoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.CategoriaVehiculoDTO;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;
import org.springframework.stereotype.Service;

@Service
public class CategoriaVehiculoConvertDTOImpl implements CategoriaVehiculoConvertDTO {

    @Override
    public CategoriaVehiculoDTO entityToDto(CategoriaVehiculo categoriaVehiculo) {
        CategoriaVehiculoDTO categoriaVehiculoDTO = new CategoriaVehiculoDTO();
        categoriaVehiculoDTO.setlCategoriaVehiculoId(categoriaVehiculo.getlCategoriaVehiculoId());
        categoriaVehiculoDTO.setvNombre(categoriaVehiculo.getvNombre());
        categoriaVehiculoDTO.setdFechaCreacion(categoriaVehiculo.getdFechaCreacion());
        return categoriaVehiculoDTO;
    }

    @Override
    public CategoriaVehiculo dtoToEntity(CategoriaVehiculoDTO categoriaVehiculoDTO) {
        CategoriaVehiculo categoriaVehiculo = new CategoriaVehiculo();
        categoriaVehiculo.setlCategoriaVehiculoId(categoriaVehiculoDTO.getlCategoriaVehiculoId());
        categoriaVehiculo.setvNombre(categoriaVehiculoDTO.getvNombre());
        categoriaVehiculo.setdFechaCreacion(categoriaVehiculoDTO.getdFechaCreacion());
        return categoriaVehiculo;
    }
}