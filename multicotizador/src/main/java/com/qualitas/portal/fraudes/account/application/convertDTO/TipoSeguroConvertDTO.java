package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.TipoSeguroDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;

public interface TipoSeguroConvertDTO {
    TipoSeguroDTO entityToDto(TipoSeguro tipoSeguro);
    TipoSeguro dtoToEntity(TipoSeguroDTO tipoSeguroDTO);
}