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

        // Crear DTO vacío
        RutinaCargaDTO dto = new RutinaCargaDTO();

        // Mapear campos básicos
        dto.setiRutinaCargaId(rutinaCarga.getiRutinaCargaId());
        dto.setvPortal(rutinaCarga.getvPortal());
        dto.setdFechaActualizacion(rutinaCarga.getdFechaActualizacion());
        dto.setiDatosObtenidos(rutinaCarga.getiDatosObtenidos());
        dto.setdProgramacion(rutinaCarga.getdProgramacion());
        dto.setvEstatus(rutinaCarga.getvEstatus());
        dto.setbHabilitado(rutinaCarga.getbHabilitado());

        // Mapear campos de ejecución
        dto.setdInicioEjecucion(rutinaCarga.getdInicioEjecucion());
        dto.setdFinEjecucion(rutinaCarga.getdFinEjecucion());
        dto.setlTiempoEjecucion(rutinaCarga.getlTiempoEjecucion());

        // Calcular campos derivados
        if (rutinaCarga.getdProgramacion() != null) {
            dto.setHoraProgramada(rutinaCarga.getdProgramacion().toLocalTime());
        }
        // VStringHabilitado se calcula automáticamente en el getter

        return dto;
    }

    @Override
    public RutinaCarga dtoToEntity(RutinaCargaDTO rutinaCargaDTO) {
        if (rutinaCargaDTO == null) {
            return null;
        }

        RutinaCarga rutinaCarga = new RutinaCarga();
        // Mapear campos básicos
        rutinaCarga.setiRutinaCargaId(rutinaCargaDTO.getiRutinaCargaId());
        rutinaCarga.setvPortal(rutinaCargaDTO.getvPortal());
        rutinaCarga.setdFechaActualizacion(rutinaCargaDTO.getdFechaActualizacion());
        rutinaCarga.setiDatosObtenidos(rutinaCargaDTO.getiDatosObtenidos());
        rutinaCarga.setdProgramacion(rutinaCargaDTO.getdProgramacion());
        rutinaCarga.setvEstatus(rutinaCargaDTO.getvEstatus());
        rutinaCarga.setbHabilitado(rutinaCargaDTO.getbHabilitado());

        // Mapear campos de ejecución
        rutinaCarga.setdInicioEjecucion(rutinaCargaDTO.getdInicioEjecucion());
        rutinaCarga.setdFinEjecucion(rutinaCargaDTO.getdFinEjecucion());
        rutinaCarga.setlTiempoEjecucion(rutinaCargaDTO.getlTiempoEjecucion());

        return rutinaCarga;
    }
}