package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.TipoAutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;

import java.math.BigDecimal;
import java.util.List;

public interface TipoAutoService {
    TipoAutoDTO crearTipoAuto(TipoAutoDTO tipoAutoDTO);
    TipoAutoDTO obtenerTipoAuto(BigDecimal id);
    TipoAutoDTO actualizarTipoAuto(BigDecimal id, TipoAutoDTO tipoAutoDTO);
    List<TipoAutoDTO> listarTiposAuto();
    void eliminarTipoAuto(BigDecimal id);

    TipoAuto obtenerTipoAutoPorNombre(String vNombre);
}