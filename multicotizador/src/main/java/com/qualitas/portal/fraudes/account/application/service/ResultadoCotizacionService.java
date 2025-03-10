package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import java.math.BigDecimal;
import java.util.List;

public interface ResultadoCotizacionService {
    ResultadoCotizacionDTO crearResultadoCotizacion(ResultadoCotizacionDTO dto);
    ResultadoCotizacionDTO obtenerResultadoCotizacion(BigDecimal id);
    List<ResultadoCotizacionDTO> listarResultadosCotizacion();
    ResultadoCotizacionDTO actualizarResultadoCotizacion(BigDecimal id, ResultadoCotizacionDTO dto);
    void eliminarResultadoCotizacion(BigDecimal id);

    boolean verificarExistenciaDeDatos();

    List<ResultadoCotizacionDTO> obtenerResultadoPorCotizacionClave(BigDecimal cotizacionClave);

    List<ResultadoCotizacionDTO> buscarPorNombreSeguroYCotizacionClave(String nombreSeguro, BigDecimal cotizacionClave);
    List<String> obtenerNombresSegurosUnicos();
}