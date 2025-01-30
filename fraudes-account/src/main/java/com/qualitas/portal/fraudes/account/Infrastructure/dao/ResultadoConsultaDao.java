package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.ResultadoConsulta;
import java.math.BigDecimal;
import java.util.List;

public interface ResultadoConsultaDao {
    ResultadoConsulta crearResultadoConsulta(ResultadoConsulta resultadoConsulta);
    ResultadoConsulta obtenerResultadoConsulta(BigDecimal id);
    ResultadoConsulta actualizarResultadoConsulta(ResultadoConsulta resultadoConsulta);
    List<ResultadoConsulta> listarResultadoConsulta();
    void eliminarResultadoConsulta(BigDecimal id);
}
