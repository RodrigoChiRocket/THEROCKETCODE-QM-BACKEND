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
        return new AutoDescripcionDTO(
                autoDescripcion.getiCatalogoAutoDescripcionId(),
                autoDescripcion.getiModeloId(),
                autoDescripcion.getvDescripcion(),
                autoDescripcion.getdFechaCreacion(),
                autoDescripcion.getiUsuarioCreacion()
        );
    }

    @Override
    public AutoDescripcion dtoToEntity(AutoDescripcionDTO autoDescripcionDTO) {
        if (autoDescripcionDTO == null) {
            return null;
        }
        return new AutoDescripcion(
                autoDescripcionDTO.getiCatalogoAutoDescripcionId(),
                autoDescripcionDTO.getiModeloId(),
                autoDescripcionDTO.getvDescripcion(),
                autoDescripcionDTO.getdFechaCreacion(),
                autoDescripcionDTO.getiUsuarioCreacion()
        );
    }
}
