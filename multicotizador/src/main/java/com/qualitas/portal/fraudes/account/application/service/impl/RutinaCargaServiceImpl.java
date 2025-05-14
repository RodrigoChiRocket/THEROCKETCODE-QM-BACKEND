package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.RutinaCargaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.EstadisticasTiempoEjecucionDTO;
import com.qualitas.portal.fraudes.account.application.service.ResultadoCotizacionService;
import com.qualitas.portal.fraudes.account.application.service.RutinaCargaService;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RutinaCargaServiceImpl implements RutinaCargaService {

    private static final Logger logger = LoggerFactory.getLogger(RutinaCargaServiceImpl.class);

    @Autowired
    private RutinaCargaDao rutinaCargaDao;

    @Autowired
    private RutinaCargaConvertDTO rutinaCargaConvertDTO;

    @Autowired
    private ResultadoCotizacionService resultadoCotizacionService;

    @Override
    public RutinaCargaDTO crearRutina(RutinaCargaDTO rutinaCargaDTO) {
        logger.info("Datos recibidos para crear RutinaCarga: {}", rutinaCargaDTO);
        RutinaCarga rutinaCarga = rutinaCargaConvertDTO.dtoToEntity(rutinaCargaDTO);
        rutinaCargaDao.crearRutina(rutinaCarga);
        logger.info("RutinaCarga guardada con éxito: {}", rutinaCarga);
        return rutinaCargaConvertDTO.entityToDto(rutinaCarga);
    }

    @Override
    public RutinaCargaDTO obtenerRutina(BigDecimal id) {
        RutinaCarga rutinaCarga = rutinaCargaDao.obtenerRutina(id);
        if (rutinaCarga == null) {
            throw new RuntimeException("RutinaCarga no encontrada con ID: " + id);
        }
        return rutinaCargaConvertDTO.entityToDto(rutinaCarga);
    }

    @Override
    public RutinaCargaDTO actualizarRutina(BigDecimal id, RutinaCargaDTO rutinaCargaDTO) {
        RutinaCarga rutinaExistente = rutinaCargaDao.obtenerRutina(id);
        if (rutinaExistente == null) {
            throw new RuntimeException("RutinaCarga no encontrada con ID: " + id);
        }
        RutinaCarga rutinaActualizada = rutinaCargaConvertDTO.dtoToEntity(rutinaCargaDTO);
        rutinaActualizada.setiRutinaCargaId(id);
        rutinaCargaDao.actualizarRutina(rutinaActualizada);
        return rutinaCargaConvertDTO.entityToDto(rutinaActualizada);
    }

    @Override
    public List<RutinaCargaDTO> listarRutinasSencilla() {
        List<RutinaCarga> rutinasModel = rutinaCargaDao.listarRutinas();
        return rutinasModel.stream()
                .map(rutinaCargaConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarRutina(BigDecimal id) {
        RutinaCarga rutinaCarga = rutinaCargaDao.obtenerRutina(id);
        if (rutinaCarga == null) {
            throw new RuntimeException("RutinaCarga no encontrada con ID: " + id);
        }
        rutinaCargaDao.eliminarRutina(id);
    }

    @Override
    public void actualizarDatosObtenidos(BigDecimal id, Integer nuevosDatos) {
        logger.info("Actualizando datos obtenidos para rutina ID: {} - Nuevo valor: {}", id, nuevosDatos);
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }
        rutinaCargaDao.actualizarDatosObtenidos(id, nuevosDatos);
        logger.info("Datos obtenidos actualizados correctamente para rutina ID: {}", id);
    }

    @Override
    public void actualizarProgramacion(BigDecimal id, LocalDateTime nuevaProgramacion) {
        logger.info("Actualizando programación para rutina ID: {} - Nueva fecha: {}", id, nuevaProgramacion);
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }
        rutinaCargaDao.actualizarProgramacion(id, nuevaProgramacion);
        logger.info("Programación actualizada correctamente para rutina ID: {}", id);
    }

    @Override
    public void actualizarHabilitado(BigDecimal id, Integer habilitado) {
        logger.info("Actualizando estado habilitado para rutina ID: {} - Nuevo valor: {}", id, habilitado);
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }
        if (habilitado != 0 && habilitado != 1) {
            throw new IllegalArgumentException("El valor de habilitado debe ser 0 o 1");
        }
        rutinaCargaDao.actualizarHabilitado(id, habilitado);
        logger.info("Estado habilitado actualizado correctamente para rutina ID: {}", id);
    }

    @Override
    public void actualizarEstatus(BigDecimal id, String vEstatus) {
        RutinaCarga rutinaCarga= rutinaCargaDao.obtenerRutina(id);
        if (rutinaCarga == null){
            throw new RuntimeException("No se encontro la rutina de carga");

        }
        rutinaCargaDao.actualizarEstatus(id, vEstatus);
    }

    @Override
    public List<RutinaCargaDTO> listarRutinas() {
        List<RutinaCarga> rutinasModel = rutinaCargaDao.listarRutinas();
        List<RutinaCargaDTO> rutinasDTO = new ArrayList<>();

        for (RutinaCarga rutina : rutinasModel) {
            try {
                // 1. Obtener todos los resultados de esta rutina
                List<ResultadoCotizacion> resultados = resultadoCotizacionService
                        .obtenerResultadosDeCatalogoPorRutina(rutina.getiRutinaCargaId());

                // 2. Verificación más robusta de errores
                boolean tieneErrores = false;
                for (ResultadoCotizacion resultado : resultados) {
                    if (resultado.getvNombreCobertura() != null &&
                            resultado.getvEstado().equalsIgnoreCase("Error")) {
                        tieneErrores = true;
                        logger.debug("Encontrado resultado con error - Rutina ID: {}, Resultado ID: {}",
                                rutina.getiRutinaCargaId(), resultado.getiResultadoCotizacionId());
                        break;
                    }
                }

                // 3. Verificar si existe cotización completada
                boolean existeCompletada = !resultados.isEmpty() &&
                        existeCotizacionCompletadaPorRutina(rutina.getiRutinaCargaId());

                // 4. Determinar el estado final (Error tiene prioridad)
                String nuevoEstado = tieneErrores ? "Error" :
                        (existeCompletada ? "Exitoso" : "No completado");

                // 5. Actualizaciones
                actualizarEstatus(rutina.getiRutinaCargaId(), nuevoEstado);
                int cantidadRegistros = resultados.size();
                actualizarDatosObtenidos(rutina.getiRutinaCargaId(), cantidadRegistros);

                rutina.setiDatosObtenidos(cantidadRegistros);
                rutina.setvEstatus(nuevoEstado);

                logger.info("Rutina ID: {} - Total registros: {} - Estado: {} - Errores: {}",
                        rutina.getiRutinaCargaId(),
                        cantidadRegistros,
                        nuevoEstado,
                        tieneErrores ? "SI" : "NO");

                rutinasDTO.add(rutinaCargaConvertDTO.entityToDto(rutina));

            } catch (Exception e) {
                logger.error("Error procesando rutina ID: {} - {}",
                        rutina.getiRutinaCargaId(), e.getMessage(), e);
                actualizarEstatus(rutina.getiRutinaCargaId(), "Error");
                rutina.setvEstatus("Error");
                rutinasDTO.add(rutinaCargaConvertDTO.entityToDto(rutina));
            }
        }
        return rutinasDTO;
    }
    @Override
    public void registrarInicioEjecucion(BigDecimal rutinaId) {
        resultadoCotizacionService.limpiarResultadosCompletadosYErrores(rutinaId);
        rutinaCargaDao.registrarInicioEjecucion(rutinaId);
    }

    @Override
    public void registrarFinEjecucion(BigDecimal rutinaId) {
        rutinaCargaDao.registrarFinEjecucion(rutinaId);
    }

    @Override
    public Long obtenerTiempoEjecucion(BigDecimal rutinaId) {
        return rutinaCargaDao.obtenerTiempoEjecucion(rutinaId);
    }

    @Override
    public boolean existeCotizacionCompletadaPorRutina(BigDecimal rutinaCargaClave) {
        return resultadoCotizacionService.existeCotizacionCompletadaPorRutina(rutinaCargaClave);
    }

    @Override
    public Map<String, Object> obtenerTiempoEjecucionDetallado(BigDecimal rutinaId) {
        logger.info("Obteniendo tiempo de ejecución detallado para rutina ID: {}", rutinaId);
        Long tiempoMs = rutinaCargaDao.obtenerTiempoEjecucion(rutinaId);

        if (tiempoMs == null) {
            logger.warn("No se encontró información de tiempo de ejecución para rutina ID: {}", rutinaId);
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("milisegundos", tiempoMs);
        response.put("formateado", formatTime(tiempoMs));
        response.put("segundos", tiempoMs / 1000);
        response.put("minutos", (tiempoMs / 1000) / 60);
        response.put("horas", ((tiempoMs / 1000) / 60) / 60);

        logger.info("Tiempo de ejecución calculado para rutina ID {}: {} ms", rutinaId, tiempoMs);
        return response;
    }

    @Override
    public Map<BigDecimal, Long> obtenerTiemposEjecucionTodasRutinas() {
        List<RutinaCarga> rutinas = rutinaCargaDao.listarRutinas();
        Map<BigDecimal, Long> tiempos = new HashMap<>();

        for (RutinaCarga rutina : rutinas) {
            Long tiempo = this.obtenerTiempoEjecucion(rutina.getiRutinaCargaId());
            if (tiempo != null) {
                tiempos.put(rutina.getiRutinaCargaId(), tiempo);
            }
        }
        return tiempos;
    }

    @Override
    public EstadisticasTiempoEjecucionDTO obtenerEstadisticasTiemposEjecucion() {
        Map<BigDecimal, Long> tiempos = obtenerTiemposEjecucionTodasRutinas();
        EstadisticasTiempoEjecucionDTO dto = new EstadisticasTiempoEjecucionDTO();

        if (tiempos.isEmpty()) {
            return dto;
        }

        // Calcular estadísticas en milisegundos
        long suma = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        // Procesar tiempos individuales
        for (Map.Entry<BigDecimal, Long> entry : tiempos.entrySet()) {
            long tiempo = entry.getValue();
            suma += tiempo;
            if (tiempo > max) max = tiempo;
            if (tiempo < min) min = tiempo;

            // Formatear tiempo individual completo (h m s)
            dto.getTiemposIndividuales().put(entry.getKey(), tiempo);
            dto.getTiemposIndividualesFormateados().put(entry.getKey(), formatTimeComplete(tiempo));
        }

        double promedio = (double) suma / tiempos.size();

        // Guardar valores en milisegundos
        dto.setPromedioMs(promedio);
        dto.setMaximoMs(max);
        dto.setMinimoMs(min);

        // Cambia esto para usar formatTimeComplete en lugar de formatTimeHoursMinutes
        dto.setPromedioFormateado(formatTimeComplete((long) promedio));
        dto.setMaximoFormateado(formatTimeComplete(max));
        dto.setMinimoFormateado(formatTimeComplete(min));

        dto.setTotalRutinas(tiempos.size());

        return dto;
    }
    // Formato completo para tiempos individuales: "Xh Ym Zs"
    // Formato completo para tiempos individuales: "Xh Ym Zs"
    // Formato completo para tiempos individuales: siempre muestra "Xh Ym Zs" incluso con ceros
    private String formatTimeComplete(long tiempoMs) {
        long totalSegundos = tiempoMs / 1000;
        long segundos = totalSegundos % 60;
        long minutos = (totalSegundos / 60) % 60;
        long horas = totalSegundos / 3600;

        return String.format("%dh %dm %ds", horas, minutos, segundos);
    }

    // Formato simplificado para resúmenes: "Xh Ym" (sin segundos)
    private String formatTimeHoursMinutes(long tiempoMs) {
        long totalSegundos = tiempoMs / 1000;
        long minutos = (totalSegundos / 60) % 60;
        long horas = totalSegundos / 3600;

        StringBuilder sb = new StringBuilder();

        if (horas > 0) {
            sb.append(horas).append("h ");
        }
        sb.append(minutos).append("m");

        return sb.toString().trim();
    }

    // Método auxiliar para formatear milisegundos a "Xh Ym" (sin segundos)


    // Método auxiliar para formatear milisegundos a HH:MM:SS

    @Override
    public Map<String, Object> obtenerEstadisticasParaGrafica() {
        EstadisticasTiempoEjecucionDTO estadisticas = obtenerEstadisticasTiemposEjecucion();
        Map<String, Object> datosGrafica = new HashMap<>();

        if (estadisticas.getTotalRutinas() == 0) {
            datosGrafica.put("mensaje", "No hay datos disponibles");
            return datosGrafica;
        }

        // Convertir a horas decimales
        double promedioHoras = estadisticas.getPromedioMs() / 3600000;
        double maximoHoras = estadisticas.getMaximoMs() / 3600000;
        double minimoHoras = estadisticas.getMinimoMs() / 3600000;

        // Formatear a 4 decimales
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        datosGrafica.put("promedio", Double.valueOf(df.format(promedioHoras)));
        datosGrafica.put("maximo", Double.valueOf(df.format(maximoHoras)));
        datosGrafica.put("minimo", Double.valueOf(df.format(minimoHoras)));
        datosGrafica.put("datos_completos", estadisticas);

        return datosGrafica;
    }

    private String formatTime(long tiempoMs) {
        long segundos = tiempoMs / 1000;
        long minutos = segundos / 60;
        long horas = minutos / 60;

        segundos = segundos % 60;
        minutos = minutos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public void actualizarTiempoEjecucion(BigDecimal rutinaId) {
        rutinaCargaDao.actualizarTiempoEjecucion(rutinaId);
    }
    @Override
    public boolean verificarYProcesarCotizacionesCompletadas(BigDecimal rutinaId) {
        boolean existenCompletadas = existeCotizacionCompletadaPorRutina(rutinaId);

        if (existenCompletadas) {
            logger.info("Procesando cotizaciones completadas para rutina ID: {}", rutinaId);

            // 1. Eliminar resultados completados
            resultadoCotizacionService.eliminarResultadosCompletadosPorRutina(rutinaId);

            // 2. Registrar fin de ejecución
            registrarFinEjecucion(rutinaId);

            // 3. Actualizar tiempo de ejecución
            actualizarTiempoEjecucion(rutinaId);

            logger.info("Proceso completado para rutina ID: {}", rutinaId);
        }

        return existenCompletadas;
    }
}