package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.Auto;

public interface AutoConvertDTO {
    Auto dtoToEntity(AutoDTO autoDTO);
    AutoDTO entityToDto(Auto auto);
}
