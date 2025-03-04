package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.AutoMarcaDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;

public interface AutoMarcaConvertDTO {

    AutoMarcaDTO entityToDto(AutoMarca autoMarca);
    AutoMarca dtoToEntity(AutoMarcaDTO autoMarcaDTO);
}
