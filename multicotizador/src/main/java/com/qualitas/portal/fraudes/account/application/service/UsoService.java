package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.UsoDTO;
import com.qualitas.portal.fraudes.account.domain.model.Uso;

import java.math.BigDecimal;
import java.util.List;

public interface UsoService {
    UsoDTO crearUso(UsoDTO usoDTO);
    UsoDTO obtenerUso(BigDecimal id);
    UsoDTO actualizarUso(BigDecimal id, UsoDTO usoDTO);
    List<UsoDTO> listarUsos();
    void eliminarUso(BigDecimal id);

    Uso obtenerUsoPorNombre(String vNombre);
}