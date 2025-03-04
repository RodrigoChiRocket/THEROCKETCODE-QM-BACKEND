package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;
import java.math.BigDecimal;
import java.util.List;

public interface TipoAutoDao {
    TipoAuto crearTipoAuto(TipoAuto tipoAuto);
    TipoAuto obtenerTipoAuto(BigDecimal id);
    TipoAuto actualizarTipoAuto(TipoAuto tipoAuto);
    List<TipoAuto> listarTiposAuto();
    void eliminarTipoAuto(BigDecimal id);
}