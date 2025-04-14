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
                rutinaCarga.getdFechaActualizacion(),
                rutinaCarga.getiDatosObtenidos(),
                rutinaCarga.getdProgramacion(),
                rutinaCarga.getvEstatus(),
                rutinaCarga.getbHabilitado()
        );
    }

    @Override
    public RutinaCarga dtoToEntity(RutinaCargaDTO rutinaCargaDTO) {
        if (rutinaCargaDTO == null) {
            return null;
        }
        RutinaCarga rutinaCarga = new RutinaCarga();
        rutinaCarga.setiRutinaCargaId(rutinaCargaDTO.getiRutinaCargaId());
        rutinaCarga.setvPortal(rutinaCargaDTO.getvPortal());
        rutinaCarga.setdFechaActualizacion(rutinaCargaDTO.getdFechaActualizacion());
        rutinaCarga.setiDatosObtenidos(rutinaCargaDTO.getiDatosObtenidos());
        rutinaCarga.setdProgramacion(rutinaCargaDTO.getdProgramacion());
        rutinaCarga.setvEstatus(rutinaCargaDTO.getvEstatus());
        rutinaCarga.setbHabilitado(rutinaCargaDTO.getbHabilitado());

        return rutinaCarga;
    }
}