package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.UsoDTO;
import com.qualitas.portal.fraudes.account.domain.model.Uso;

public interface UsoConvertDTO {
    UsoDTO entityToDto(Uso uso);
    Uso dtoToEntity(UsoDTO usoDTO);
}