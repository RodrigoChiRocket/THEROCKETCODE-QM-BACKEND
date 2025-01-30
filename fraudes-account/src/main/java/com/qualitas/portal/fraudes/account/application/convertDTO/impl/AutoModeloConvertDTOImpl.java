package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoModeloConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AutoModeloConvertDTOImpl implements AutoModeloConvertDTO {

    @Override
    public AutoModeloDTO entityToDto(AutoModelo autoModelo) {
        if (autoModelo == null) {
            return null;
        }
        return new AutoModeloDTO(
                autoModelo.getiCatalogoAutoModeloId(),
                autoModelo.getiAutoId(),
                autoModelo.getvDescripcion(),
                autoModelo.getdFechaCreacion(),
                autoModelo.getiUsuarioCreacion()

        );
    }

    @Override
    public AutoModelo dtoToEntity(AutoModeloDTO autoModeloDTO) {
        if (autoModeloDTO == null) {
            return null;
        }
        return new AutoModelo(
                autoModeloDTO.getiCatalogoAutoModeloId(),
                autoModeloDTO.getiAutoId(),
                autoModeloDTO.getvDescripcion(),
                autoModeloDTO.getdFechaCreacion(),
                autoModeloDTO.getiUsuarioCreacion()
        );
    }
}
