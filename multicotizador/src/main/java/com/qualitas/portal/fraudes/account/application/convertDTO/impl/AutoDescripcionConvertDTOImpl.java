package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoDescripcionConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDescripcionDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import org.springframework.stereotype.Service;

@Service
public class AutoDescripcionConvertDTOImpl implements AutoDescripcionConvertDTO {

    @Override
    public AutoDescripcionDTO entityToDto(AutoDescripcion autoDescripcion) {
        AutoDescripcionDTO autoDescripcionDTO = new AutoDescripcionDTO();
        autoDescripcionDTO.setiAutoDescripcionId(autoDescripcion.getiAutoDescripcionId());
        autoDescripcionDTO.setiAutoModeloClave(autoDescripcion.getiAutoModeloClave());
        autoDescripcionDTO.setvNombre(autoDescripcion.getvNombre());
        autoDescripcionDTO.setdFechaCreacion(autoDescripcion.getdFechaCreacion());
        autoDescripcionDTO.setiUsuarioCreacion(autoDescripcion.getiUsuarioCreacion());
        return autoDescripcionDTO;
    }

    @Override
    public AutoDescripcion dtoToEntity(AutoDescripcionDTO autoDescripcionDTO) {
        AutoDescripcion autoDescripcion = new AutoDescripcion();
        autoDescripcion.setiAutoDescripcionId(autoDescripcionDTO.getiAutoDescripcionId());
        autoDescripcion.setiAutoModeloClave(autoDescripcionDTO.getiAutoModeloClave());
        autoDescripcion.setvNombre(autoDescripcionDTO.getvNombre());
        autoDescripcion.setdFechaCreacion(autoDescripcionDTO.getdFechaCreacion());
        autoDescripcion.setiUsuarioCreacion(autoDescripcionDTO.getiUsuarioCreacion());
        return autoDescripcion;
    }
}