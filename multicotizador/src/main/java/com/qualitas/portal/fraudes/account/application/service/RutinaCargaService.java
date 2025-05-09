package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.EstadisticasTiempoEjecucionDTO;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface RutinaCargaService {
    RutinaCargaDTO crearRutina(RutinaCargaDTO rutinaCargaDTO);
    RutinaCargaDTO obtenerRutina(BigDecimal id);
    RutinaCargaDTO actualizarRutina(BigDecimal id, RutinaCargaDTO rutinaCargaDTO);
    List<RutinaCargaDTO> listarRutinas();
    void eliminarRutina(BigDecimal id);

    void actualizarDatosObtenidos(BigDecimal id, Integer nuevosDatos);
    void actualizarProgramacion(BigDecimal id, LocalDateTime nuevaProgramacion);
    void actualizarHabilitado(BigDecimal id, Integer habilitado);
    void actualizarEstatus(BigDecimal id, String vEstatus);


    List<RutinaCargaDTO> listarRutinasSencilla();
    void registrarInicioEjecucion(BigDecimal rutinaId);
    void registrarFinEjecucion(BigDecimal rutinaId);
    Long obtenerTiempoEjecucion(BigDecimal rutinaId);
    boolean existeCotizacionCompletadaPorRutina(BigDecimal rutinaCargaClave);



    Map<String, Object> obtenerTiempoEjecucionDetallado(BigDecimal rutinaId);
    Map<BigDecimal, Long> obtenerTiemposEjecucionTodasRutinas();
    EstadisticasTiempoEjecucionDTO obtenerEstadisticasTiemposEjecucion();
    Map<String, Object> obtenerEstadisticasParaGrafica();
    void actualizarTiempoEjecucion(BigDecimal rutinaId);

    boolean verificarYProcesarCotizacionesCompletadas(BigDecimal rutinaId);
}