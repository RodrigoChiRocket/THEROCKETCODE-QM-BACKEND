package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import java.math.BigDecimal;
import java.util.List;

public interface ResultadoCotizacionService {
    ResultadoCotizacionDTO crearResultadoCotizacion(ResultadoCotizacionDTO dto);


    ResultadoCotizacionDTO crearResultadoCotizacionCatalogo(ResultadoCotizacionDTO dto);

    ResultadoCotizacionDTO obtenerResultadoCotizacion(BigDecimal id);
    List<ResultadoCotizacionDTO> listarResultadosCotizacion();
    ResultadoCotizacionDTO actualizarResultadoCotizacion(BigDecimal id, ResultadoCotizacionDTO dto);
    void eliminarResultadoCotizacion(BigDecimal id);

    boolean verificarEstadoCotizacion(BigDecimal cotizacionClave);


    List<ResultadoCotizacionDTO> obtenerResultadoPorCotizacionClave(BigDecimal cotizacionClave);

    List<ResultadoCotizacionDTO> buscarPorNombreSeguroYCotizacionClave(String nombreSeguro, BigDecimal cotizacionClave);
    List<String> obtenerNombresSegurosUnicos();

    List<ResultadoCotizacionDTO> filtrarResultadosCotizacion(BigDecimal cotizacionClave, String nombreSeguro, String nombreCobertura);

    int contarRegistrosPorRutina(BigDecimal rutinaClave);

    List<ResultadoCotizacionDTO> obtenerResultadoCotizacionPorCatalogo();


    boolean existeCotizacionCompletadaPorRutina(BigDecimal rutinaCargaClave);

    /**
     * Elimina los resultados de cotización completados para una rutina de carga específica
     * @param rutinaCargaClave Identificador de la rutina de carga
     * @return true si se eliminaron registros, false si no había registros para eliminar
     */
    boolean eliminarResultadosCompletadosPorRutina(BigDecimal rutinaCargaClave);

}