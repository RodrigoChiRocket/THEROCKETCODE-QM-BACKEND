package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.TipoSeguroConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.TipoSeguroDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;
import org.springframework.stereotype.Service;

@Service
public class TipoSeguroConvertDTOImpl implements TipoSeguroConvertDTO {

    @Override
    public TipoSeguroDTO entityToDto(TipoSeguro tipoSeguro) {
        TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
        tipoSeguroDTO.setlTipoSeguroId(tipoSeguro.getlTipoSeguroId());
        tipoSeguroDTO.setvNombre(tipoSeguro.getvNombre());
        tipoSeguroDTO.setdFechaCreacion(tipoSeguro.getdFechaCreacion());
        tipoSeguroDTO.setlUsuarioCreacion(tipoSeguro.getlUsuarioCreacion());
        return tipoSeguroDTO;
    }

    @Override
    public TipoSeguro dtoToEntity(TipoSeguroDTO tipoSeguroDTO) {
        TipoSeguro tipoSeguro = new TipoSeguro();
        tipoSeguro.setlTipoSeguroId(tipoSeguroDTO.getlTipoSeguroId());
        tipoSeguro.setvNombre(tipoSeguroDTO.getvNombre());
        tipoSeguro.setdFechaCreacion(tipoSeguroDTO.getdFechaCreacion());
        tipoSeguro.setlUsuarioCreacion(tipoSeguroDTO.getlUsuarioCreacion());
        return tipoSeguro;
    }
}