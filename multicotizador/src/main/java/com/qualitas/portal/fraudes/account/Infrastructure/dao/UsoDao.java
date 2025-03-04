package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Uso;
import java.math.BigDecimal;
import java.util.List;

public interface UsoDao {
    Uso crearUso(Uso uso);
    Uso obtenerUso(BigDecimal id);
    Uso actualizarUso(Uso uso);
    List<Uso> listarUsos();
    void eliminarUso(BigDecimal id);
}