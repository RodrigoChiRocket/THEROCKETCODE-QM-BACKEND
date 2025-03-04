package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoMarcaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoMarcaDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;


import org.springframework.stereotype.Service;

@Service
public class AutoMarcaConvertDTOImpl implements AutoMarcaConvertDTO {

    @Override
    public AutoMarcaDTO entityToDto(AutoMarca autoMarca) {

        AutoMarcaDTO autoMarcaDTO = new AutoMarcaDTO();
        autoMarcaDTO.setiAutoMarcaId(autoMarca.getiAutoMarcaId());
        autoMarcaDTO.setvNombre(autoMarca.getvNombre());
        autoMarcaDTO.setdFechaCreacion(autoMarca.getdFechaCreacion());
        autoMarcaDTO.setiUsuarioCreacion(autoMarca.getiUsuarioCreacion());

        return autoMarcaDTO;
    }

    @Override
    public AutoMarca dtoToEntity(AutoMarcaDTO autoMarcaDTO) {

        AutoMarca autoMarca = new AutoMarca();
        autoMarca.setiAutoMarcaId(autoMarcaDTO.getiAutoMarcaId());
        autoMarca.setvNombre(autoMarcaDTO.getvNombre());
        autoMarca.setdFechaCreacion(autoMarcaDTO.getdFechaCreacion());
        autoMarca.setiUsuarioCreacion(autoMarcaDTO.getiUsuarioCreacion());

        return autoMarca;
    }
}
