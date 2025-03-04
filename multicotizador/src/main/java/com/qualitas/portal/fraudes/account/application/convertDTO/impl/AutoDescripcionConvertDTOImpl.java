package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoDescripcionConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDescripcionDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import org.springframework.stereotype.Service;

@Service
public class AutoDescripcionConvertDTOImpl implements AutoDescripcionConvertDTO {

    @Override
    public AutoDescripcionDTO entityToDto(AutoDescripcion autoDescripcion) {
        if (autoDescripcion == null) {
            return null;
        }
        AutoDescripcionDTO autoDescripcionDTO = new AutoDescripcionDTO();
        autoDescripcionDTO.setiCatalogoAutoDescripcionId(autoDescripcion.getiAutoDescripcionId());
        autoDescripcionDTO.setiAutoModeloClave(autoDescripcion.getiAutoModeloClave());  // Obtener el ID del modelo
        autoDescripcionDTO.setvNombre(autoDescripcion.getvNombre());
        autoDescripcionDTO.setdFechaCreacion(autoDescripcion.getdFechaCreacion());
        autoDescripcionDTO.setiUsuarioCreacion(autoDescripcion.getiUsuarioCreacion());
        return autoDescripcionDTO;
    }

    @Override
    public AutoDescripcion dtoToEntity(AutoDescripcionDTO autoDescripcionDTO) {
        if (autoDescripcionDTO == null) {
            return null;
        }
        AutoDescripcion autoDescripcion = new AutoDescripcion();
        autoDescripcion.setiAutoDescripcionId(autoDescripcionDTO.getiCatalogoAutoDescripcionId());

        autoDescripcion.setiAutoModeloClave(autoDescripcion.getiAutoModeloClave());

        autoDescripcion.setvNombre(autoDescripcionDTO.getvNombre());
        autoDescripcion.setdFechaCreacion(autoDescripcionDTO.getdFechaCreacion());
        autoDescripcion.setiUsuarioCreacion(autoDescripcionDTO.getiUsuarioCreacion());
        return autoDescripcion;
    }
}
