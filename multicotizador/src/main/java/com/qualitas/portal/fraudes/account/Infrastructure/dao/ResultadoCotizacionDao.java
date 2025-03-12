package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ResultadoCotizacionDao {
    ResultadoCotizacion crearResultadoCotizacion(ResultadoCotizacion resultado);
    ResultadoCotizacion obtenerResultadoCotizacion(BigDecimal id);
    List<ResultadoCotizacion> listarResultadosCotizacion();
    ResultadoCotizacion actualizarResultadoCotizacion(ResultadoCotizacion resultado);
    void eliminarResultadoCotizacion(BigDecimal id);

     List<ResultadoCotizacion> obtenerResultadoPorCotizacionClave(BigDecimal cotizacionClave);

    List<ResultadoCotizacion> buscarPorNombreSeguroYCotizacionClave(
            @Param("nombreSeguro") String nombreSeguro,
            @Param("cotizacionClave") BigDecimal cotizacionClave
    );

    List<String> obtenerNombresSegurosUnicos();

    boolean verificarEstadoCotizacion(BigDecimal cotizacionClave); // Cambiado a boolean
}