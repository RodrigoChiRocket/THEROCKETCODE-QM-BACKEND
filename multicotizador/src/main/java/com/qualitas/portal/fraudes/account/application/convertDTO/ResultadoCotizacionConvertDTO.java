package com.qualitas.portal.fraudes.account.application.convertDTO;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;

import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;

public interface ResultadoCotizacionConvertDTO {
    ResultadoCotizacion dtoToEntity(com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO dto);
    ResultadoCotizacionDTO entityToDto(ResultadoCotizacion entity);
}