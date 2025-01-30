package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import com.qualitas.portal.fraudes.account.application.convertDTO.RutinaCargaConvertDTO;
import org.springframework.stereotype.Component;

@Component
public class RutinaCargaConvertDTOImpl implements RutinaCargaConvertDTO {

    @Override
    public RutinaCargaDTO entityToDto(RutinaCarga rutinaCarga) {
        if (rutinaCarga == null) {
            return null;
        }
        return new RutinaCargaDTO(
                rutinaCarga.getiRutinaCargaId(),
                rutinaCarga.getvPortal(),
                rutinaCarga.getdFechaActual(),
                rutinaCarga.getvNRODatos(),
                rutinaCarga.getvProgramacion(),
                rutinaCarga.getvEstatus(),
                rutinaCarga.getvHabilitado()
        );
    }

    @Override
    public RutinaCarga dtoToEntity(RutinaCargaDTO rutinaCargaDTO) {
        if (rutinaCargaDTO == null) {
            return null;
        }
        return new RutinaCarga(
                rutinaCargaDTO.getiRutinaCargaId(),
                rutinaCargaDTO.getvPortal(),
                rutinaCargaDTO.getdFechaActual(),
                rutinaCargaDTO.getvNRODatos(),
                rutinaCargaDTO.getvProgramacion(),
                rutinaCargaDTO.getvEstatus(),
                rutinaCargaDTO.getvHabilitado()
        );
    }
}
