package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.RutinaCargaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import com.qualitas.portal.fraudes.account.application.service.ResultadoCotizacionService;
import com.qualitas.portal.fraudes.account.application.service.RutinaCargaService;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//vbhtz0p

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
    public List<RutinaCargaDTO> listarRutinas() {
        // 1. Obtener todas las rutinas
        List<RutinaCarga> rutinasModel = rutinaCargaDao.listarRutinas();

        // 2. Lista para los resultados DTO
        List<RutinaCargaDTO> rutinasDTO = new ArrayList<>();

        // 3. Procesar cada rutina
        for (RutinaCarga rutina : rutinasModel) {
            try {
                // 4. Contar registros en RESULTADO_COTIZACION para esta rutina
                int cantidadRegistros = resultadoCotizacionService.contarRegistrosPorRutina(rutina.getiRutinaCargaId());

                // 5. Actualizar el campo iDatosObtenidos en la base de datos
                actualizarDatosObtenidos(rutina.getiRutinaCargaId(), cantidadRegistros);

                // 6. Actualizar el objeto en memoria para reflejar el cambio
                rutina.setiDatosObtenidos(cantidadRegistros);

                // 7. Log de depuración
                logger.info("Rutina ID: {} - Registros contados: {}",
                        rutina.getiRutinaCargaId(), cantidadRegistros);

                // 8. Convertir a DTO
                RutinaCargaDTO dto = rutinaCargaConvertDTO.entityToDto(rutina);
                rutinasDTO.add(dto);

            } catch (Exception e) {
                logger.error("Error procesando rutina ID: {}", rutina.getiRutinaCargaId(), e);
                // Si falla una rutina, continuar con las demás
                RutinaCargaDTO dto = rutinaCargaConvertDTO.entityToDto(rutina);
                rutinasDTO.add(dto);
            }
        }

        return rutinasDTO;
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

        // Verificar que la rutina existe
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }

        // Actualizar solo el campo iDatosObtenidos
        rutinaCargaDao.actualizarDatosObtenidos(id, nuevosDatos);

        logger.info("Datos obtenidos actualizados correctamente para rutina ID: {}", id);
    }

    @Override
    public void actualizarProgramacion(BigDecimal id, LocalDateTime nuevaProgramacion) {
        logger.info("Actualizando programación para rutina ID: {} - Nueva fecha: {}", id, nuevaProgramacion);

        // Verificar que la rutina existe
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }

        // Actualizar solo el campo dProgramacion
        rutinaCargaDao.actualizarProgramacion(id, nuevaProgramacion);

        logger.info("Programación actualizada correctamente para rutina ID: {}", id);
    }

    @Override
    public void actualizarHabilitado(BigDecimal id, Integer habilitado) {
        logger.info("Actualizando estado habilitado para rutina ID: {} - Nuevo valor: {}", id, habilitado);

        // Verificar que la rutina existe
        RutinaCarga rutina = rutinaCargaDao.obtenerRutina(id);
        if (rutina == null) {
            throw new RuntimeException("No se encontró la rutina con ID: " + id);
        }

        // Validar que el valor es 0 o 1
        if (habilitado != 0 && habilitado != 1) {
            throw new IllegalArgumentException("El valor de habilitado debe ser 0 o 1");
        }

        rutinaCargaDao.actualizarHabilitado(id, habilitado);
        logger.info("Estado habilitado actualizado correctamente para rutina ID: {}", id);
    }

}
