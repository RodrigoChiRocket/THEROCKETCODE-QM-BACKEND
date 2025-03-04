package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AutoModeloService {
    AutoModeloDTO crearAuto(AutoModeloDTO autoModeloDTO);
    AutoModeloDTO obtenerAuto(BigDecimal id);
    AutoModeloDTO actualizarAuto(BigDecimal id, AutoModeloDTO autoModeloDTO);
    List<AutoModeloDTO> listarAutos();
    void eliminarAuto(BigDecimal id);
}
