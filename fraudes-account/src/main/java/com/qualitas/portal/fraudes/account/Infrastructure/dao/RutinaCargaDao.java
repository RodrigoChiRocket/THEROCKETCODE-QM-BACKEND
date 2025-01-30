package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import java.math.BigDecimal;
import java.util.List;

public interface RutinaCargaDao {
    RutinaCarga crearRutina(RutinaCarga rutinaCarga);
    RutinaCarga obtenerRutina(BigDecimal id);
    RutinaCarga actualizarRutina(RutinaCarga rutinaCarga);
    List<RutinaCarga> listarRutinas();
    void eliminarRutina(BigDecimal id);
}
