package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.TipoSeguroDTO;
import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;

import java.math.BigDecimal;
import java.util.List;

public interface TipoSeguroService {
    TipoSeguroDTO crearTipoSeguro(TipoSeguroDTO tipoSeguroDTO);
    TipoSeguroDTO obtenerTipoSeguro(BigDecimal id);
    TipoSeguroDTO actualizarTipoSeguro(BigDecimal id, TipoSeguroDTO tipoSeguroDTO);
    List<TipoSeguroDTO> listarTiposSeguro();
    void eliminarTipoSeguro(BigDecimal id);

    TipoSeguro obtenerTipoSeguroPorNombre(String vNombre);
}