package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.ResultadoConsultaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.ResultadoConsultaDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoConsulta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ResultadoConsultaConvertDTOImpl implements ResultadoConsultaConvertDTO {

    @Override
    public ResultadoConsulta dtoToEntity(ResultadoConsultaDTO dto) {
        if (dto == null) {
            return null;
        }

        ResultadoConsulta entity = new ResultadoConsulta();
        entity.setiResultCargaId(dto.getiResultCargaId());
        entity.setvNombre(dto.getvNombre());
        entity.setvSexo(dto.getvSexo());
        entity.setiCodigoPostal(dto.getiCodigoPostal());
        entity.setdFechaNacimiento(dto.getdFechaNacimiento());
        entity.setiAutoId(dto.getiAutoId());
        entity.setiModeloId(dto.getiModeloId());
        entity.setiAutoDescripcionId(dto.getiAutoDescripcionId());
        entity.setdFechaCreacion(dto.getdFechaCreacion());
        entity.setiUsuarioCreacion(dto.getiUsuarioCreacion());

        return entity;
    }

    @Override
    public ResultadoConsultaDTO entityToDto(ResultadoConsulta entity) {
        if (entity == null) {
            return null;
        }

        ResultadoConsultaDTO dto = new ResultadoConsultaDTO();
        dto.setiResultCargaId(entity.getiResultCargaId());
        dto.setvNombre(entity.getvNombre());
        dto.setvSexo(entity.getvSexo());
        dto.setiCodigoPostal(entity.getiCodigoPostal());
        dto.setdFechaNacimiento(entity.getdFechaNacimiento());
        dto.setiAutoId(entity.getiAutoId());
        dto.setiModeloId(entity.getiModeloId());
        dto.setiAutoDescripcionId(entity.getiAutoDescripcionId());
        dto.setdFechaCreacion(entity.getdFechaCreacion());
        dto.setiUsuarioCreacion(entity.getiUsuarioCreacion());

        return dto;
    }
}
