package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Auto;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;

import java.math.BigDecimal;
import java.util.List;

public interface AutoModeloDao {

    AutoModelo crearAuto(AutoModelo auto);
    AutoModelo obtenerAuto(BigDecimal id);
    AutoModelo actualizarAuto(AutoModelo auto);
    List<AutoModelo> listarAuto();
    void eliminarAuto(BigDecimal id);
}
