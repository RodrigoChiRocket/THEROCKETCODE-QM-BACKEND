package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.AutoDescripcionDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;

public interface AutoDescripcionConvertDTO {
    AutoDescripcionDTO entityToDto(AutoDescripcion autoDescripcion);
    AutoDescripcion dtoToEntity(AutoDescripcionDTO autoDescripcionDTO);
}
