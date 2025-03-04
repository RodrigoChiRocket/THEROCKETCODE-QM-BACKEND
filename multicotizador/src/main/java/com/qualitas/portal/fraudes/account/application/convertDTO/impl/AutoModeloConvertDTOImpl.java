package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoModeloConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;
import org.springframework.stereotype.Service;

@Service
public class AutoModeloConvertDTOImpl implements AutoModeloConvertDTO {

    @Override
    public AutoModeloDTO entityToDto(AutoModelo autoModelo) {
        AutoModeloDTO autoModeloDTO = new AutoModeloDTO();
        autoModeloDTO.setiAutoModeloId(autoModelo.getiAutoModeloId());
        autoModeloDTO.setiAutoMarcaClave(autoModelo.getiAutoMarcaClave());
        autoModeloDTO.setvNombre(autoModelo.getvNombre());
        autoModeloDTO.setdFechaCreacion(autoModelo.getdFechaCreacion());
        autoModeloDTO.setiUsuarioCreacion(autoModelo.getiUsuarioCreacion());
        return autoModeloDTO;
    }

    @Override
    public AutoModelo dtoToEntity(AutoModeloDTO autoModeloDTO) {
        AutoModelo autoModelo = new AutoModelo();
        autoModelo.setiAutoModeloId(autoModeloDTO.getiAutoModeloId());
        autoModelo.setiAutoMarcaClave(autoModeloDTO.getiAutoMarcaClave()); // Asignar el ID de la marca
        autoModelo.setvNombre(autoModeloDTO.getvNombre());
        autoModelo.setdFechaCreacion(autoModeloDTO.getdFechaCreacion());
        autoModelo.setiUsuarioCreacion(autoModeloDTO.getiUsuarioCreacion());
        return autoModelo;
    }
}