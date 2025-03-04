package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Auto;

import java.math.BigDecimal;
import java.util.List;

public interface AutoDao {
    Auto crearAuto(Auto auto);
    Auto obtenerAuto(BigDecimal id);
    Auto actualizarAuto(Auto auto);
    List<Auto> listarAuto();
    void eliminarAuto(BigDecimal id);
}
