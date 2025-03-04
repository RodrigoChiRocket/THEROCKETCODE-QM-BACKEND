package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDescripcionDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AutoDescripcionService {
    AutoDescripcionDTO crearAuto(AutoDescripcionDTO autoDescripcionDTO);
    AutoDescripcionDTO obtenerAuto(BigDecimal id);
    AutoDescripcionDTO actualizarAuto(BigDecimal id, AutoDescripcionDTO autoDescripcionDTO);
    List<AutoDescripcionDTO> listarAutos();
    void eliminarAuto(BigDecimal id);
}
