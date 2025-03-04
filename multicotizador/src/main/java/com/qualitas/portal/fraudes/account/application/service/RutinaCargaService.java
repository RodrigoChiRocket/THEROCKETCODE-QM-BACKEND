package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import java.math.BigDecimal;
import java.util.List;

public interface RutinaCargaService {
    RutinaCargaDTO crearRutina(RutinaCargaDTO rutinaCargaDTO);
    RutinaCargaDTO obtenerRutina(BigDecimal id);
    RutinaCargaDTO actualizarRutina(BigDecimal id, RutinaCargaDTO rutinaCargaDTO);
    List<RutinaCargaDTO> listarRutinas();
    void eliminarRutina(BigDecimal id);
}
