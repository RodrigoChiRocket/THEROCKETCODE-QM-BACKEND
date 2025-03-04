package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.ResultadoConsultaDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoConsulta;

public interface ResultadoConsultaConvertDTO {
    ResultadoConsulta dtoToEntity(ResultadoConsultaDTO resultadoConsultaDTO);
    ResultadoConsultaDTO entityToDto(ResultadoConsulta resultadoConsulta);
}
