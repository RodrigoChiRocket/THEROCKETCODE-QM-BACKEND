package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;
import java.math.BigDecimal;
import java.util.List;

public interface TipoSeguroDao {
    TipoSeguro crearTipoSeguro(TipoSeguro tipoSeguro);
    TipoSeguro obtenerTipoSeguro(BigDecimal id);
    TipoSeguro actualizarTipoSeguro(TipoSeguro tipoSeguro);
    List<TipoSeguro> listarTiposSeguro();
    void eliminarTipoSeguro(BigDecimal id);


    TipoSeguro obtenerTipoSeguroPorNombre(String vNombre);
}