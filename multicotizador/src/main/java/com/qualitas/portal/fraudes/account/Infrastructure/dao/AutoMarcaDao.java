package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;
import java.math.BigDecimal;
import java.util.List;

public interface AutoMarcaDao {
    AutoMarca crearAutoMarca(AutoMarca autoMarca);
    AutoMarca obtenerAutoMarca(BigDecimal id);
    AutoMarca actualizarAutoMarca(AutoMarca autoMarca);
    List<AutoMarca> listarAutoMarcas();
    void eliminarAutoMarca(BigDecimal id);
}