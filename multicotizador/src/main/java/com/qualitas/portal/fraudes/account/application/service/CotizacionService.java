package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.CotizacionCompletaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CotizacionService {
    CotizacionCompletaResponseDTO crearCotizacionCompleta(CotizacionCompletaDTO cotizacionCompletaDTO);

    CotizacionDTO crearCotizacion(CotizacionDTO cotizacionDTO);
    CotizacionDTO obtenerCotizacionPorId(BigDecimal id);
    CotizacionDTO actualizarCotizacion(CotizacionDTO cotizacionDTO);
    void eliminarCotizacion(BigDecimal id);
    List<CotizacionDTO> listarTodasLasCotizaciones();
}