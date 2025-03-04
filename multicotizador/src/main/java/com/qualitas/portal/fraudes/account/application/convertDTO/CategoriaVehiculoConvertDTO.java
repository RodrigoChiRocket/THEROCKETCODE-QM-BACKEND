package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.CategoriaVehiculoDTO;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;

public interface CategoriaVehiculoConvertDTO {
    CategoriaVehiculoDTO entityToDto(CategoriaVehiculo categoriaVehiculo);
    CategoriaVehiculo dtoToEntity(CategoriaVehiculoDTO categoriaVehiculoDTO);
}