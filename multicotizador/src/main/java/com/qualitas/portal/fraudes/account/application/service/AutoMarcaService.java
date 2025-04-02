package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoMarcaDTO;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;

import java.math.BigDecimal;
import java.util.List;

public interface AutoMarcaService {
    AutoMarcaDTO crearAutoMarca(AutoMarcaDTO autoMarcaDTO);
    AutoMarcaDTO obtenerAutoMarca(BigDecimal id);
    AutoMarcaDTO actualizarAutoMarca(BigDecimal id, AutoMarcaDTO autoMarcaDTO);
    List<AutoMarcaDTO> listarAutoMarcas();
    void eliminarAutoMarca(BigDecimal id);

    AutoMarcaDTO obtenerAutoMarcaPorNombre(String nombre);

}