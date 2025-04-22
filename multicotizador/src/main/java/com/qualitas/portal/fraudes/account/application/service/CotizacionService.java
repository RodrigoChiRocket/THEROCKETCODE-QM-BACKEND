package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.CotizacionCompletaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.domain.model.Cotizacion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CotizacionService {
    CotizacionCompletaResponseDTO crearCotizacionCompleta(CotizacionCompletaDTO cotizacionCompletaDTO);

    CotizacionCompletaResponseDTO crearCotizacionCompletaCatalogo(CotizacionCompletaDTO cotizacionCompletaDTO);
    CotizacionDTO crearCotizacion(CotizacionDTO cotizacionDTO);
    CotizacionDTO crearCotizacionCatalogo(CotizacionDTO cotizacionDTO);
    CotizacionDTO obtenerCotizacionPorId(BigDecimal id);

    CotizacionDTO actualizarCotizacion(BigDecimal id, CotizacionDTO cotizacionDTO);


    CotizacionCompletaResponseDTO actualizarCotizacionCompleta(BigDecimal cotizacionId, CotizacionCompletaDTO requestDTO);

    void eliminarCotizacion(BigDecimal id);
    List<CotizacionCompletaResponseDTO> listarTodasLasCotizaciones();

    void eliminarListaCotizacion(Set<BigDecimal> cotizacionesId);






 List<CotizacionCompletaResponseDTO> listarCotizacionesCompletasPaginadas(int offset, int limit);


    List<CotizacionCompletaResponseDTO> listarCotizacionesCompletas();


    int contarTotalCotizaciones();
}