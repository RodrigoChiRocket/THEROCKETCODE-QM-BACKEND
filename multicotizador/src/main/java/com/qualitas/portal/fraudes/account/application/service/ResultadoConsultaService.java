package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.ResultadoConsultaDTO;
import java.math.BigDecimal;
import java.util.List;

public interface ResultadoConsultaService {
    ResultadoConsultaDTO crearResultadoConsulta(ResultadoConsultaDTO resultadoConsultaDTO);
    ResultadoConsultaDTO obtenerResultadoConsulta(BigDecimal id);
    ResultadoConsultaDTO actualizarResultadoConsulta(BigDecimal id, ResultadoConsultaDTO resultadoConsultaDTO);
    List<ResultadoConsultaDTO> listarResultadosConsulta();
    void eliminarResultadoConsulta(BigDecimal id);
}
