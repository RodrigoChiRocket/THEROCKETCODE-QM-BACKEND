package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.TipoAutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;

public interface TipoAutoConvertDTO {
    TipoAutoDTO entityToDto(TipoAuto tipoAuto);
    TipoAuto dtoToEntity(TipoAutoDTO tipoAutoDTO);
}