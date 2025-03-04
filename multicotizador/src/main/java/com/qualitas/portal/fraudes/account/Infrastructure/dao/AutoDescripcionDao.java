package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;

import java.math.BigDecimal;
import java.util.List;

public interface AutoDescripcionDao {

    AutoDescripcion crearAuto(AutoDescripcion autoDescripcion);
    AutoDescripcion obtenerAuto(BigDecimal id);
    AutoDescripcion actualizarAuto(AutoDescripcion autoDescripcion);
    List<AutoDescripcion> listarAuto();
    void eliminarAuto(BigDecimal id);
}
