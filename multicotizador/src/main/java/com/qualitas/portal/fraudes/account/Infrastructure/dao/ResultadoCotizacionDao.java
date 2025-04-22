package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.application.dto.response.EstadisticasCoberturaDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    List<ResultadoCotizacion> filtrarResultadosCotizacion(Map<String, Object> parametros);

    int contarRegistrosPorRutina(BigDecimal rutinaClave);





    /*
    Catalogo y rutinas
     */

    boolean existeCotizacionCompletadaPorRutina(BigDecimal rutinaCargaClave);

    ResultadoCotizacion crearResultadoCotizacionCatalogo(ResultadoCotizacion resultadoCotizacion);


    List<ResultadoCotizacion> obtenerResultadoDeCatalogo();


    void eliminarResultadosCotizacionCompletados(BigDecimal rutinaCargaClave);





    /*
    Dashboard
     */

    List<Map<String, Object>> obtenerConteoResultadosPorMes();

    EstadisticasCoberturaDTO obtenerEstadisticasCoberturasMesActual();
}