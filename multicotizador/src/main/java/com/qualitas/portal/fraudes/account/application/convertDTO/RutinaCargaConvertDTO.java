package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;

public interface RutinaCargaConvertDTO {
    RutinaCargaDTO entityToDto(RutinaCarga rutinaCarga);
    RutinaCarga dtoToEntity(RutinaCargaDTO rutinaCargaDTO);
}
