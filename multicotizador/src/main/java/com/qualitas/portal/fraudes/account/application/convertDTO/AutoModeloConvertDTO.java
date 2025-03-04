package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;

public interface AutoModeloConvertDTO {
    AutoModeloDTO entityToDto(AutoModelo autoModelo);
    AutoModelo dtoToEntity(AutoModeloDTO autoModeloDTO);
}
