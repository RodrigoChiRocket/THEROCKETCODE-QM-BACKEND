package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.TipoAutoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.TipoAutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;
import org.springframework.stereotype.Service;

@Service
public class TipoAutoConvertDTOImpl implements TipoAutoConvertDTO {

    @Override
    public TipoAutoDTO entityToDto(TipoAuto tipoAuto) {
        TipoAutoDTO tipoAutoDTO = new TipoAutoDTO();
        tipoAutoDTO.setlTipoAutoId(tipoAuto.getlTipoAutoId());
        tipoAutoDTO.setvNombre(tipoAuto.getvNombre());
        tipoAutoDTO.setdFechaCreacion(tipoAuto.getdFechaCreacion());
        tipoAutoDTO.setlUsuarioCreacion(tipoAuto.getlUsuarioCreacion());
        return tipoAutoDTO;
    }

    @Override
    public TipoAuto dtoToEntity(TipoAutoDTO tipoAutoDTO) {
        TipoAuto tipoAuto = new TipoAuto();
        tipoAuto.setlTipoAutoId(tipoAutoDTO.getlTipoAutoId());
        tipoAuto.setvNombre(tipoAutoDTO.getvNombre());
        tipoAuto.setdFechaCreacion(tipoAutoDTO.getdFechaCreacion());
        tipoAuto.setlUsuarioCreacion(tipoAutoDTO.getlUsuarioCreacion());
        return tipoAuto;
    }
}