package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AutoService {
    AutoDTO crearAuto(AutoDTO autoDTO);
    AutoDTO obtenerAuto(BigDecimal id);
    AutoDTO actualizarAuto(BigDecimal id, AutoDTO autoDTO);
    List<AutoDTO> listarAutos();
    void eliminarAuto(BigDecimal id);
}
