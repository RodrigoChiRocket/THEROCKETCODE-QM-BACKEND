package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.AutoDescripcionConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDescripcionDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoDescripcionService;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoDescripcionServiceImpl implements AutoDescripcionService {

    private static final Logger logger = LoggerFactory.getLogger(AutoDescripcionServiceImpl.class);

    @Autowired
    private AutoDescripcionDao autoDescripcionDao;

    @Autowired
    private AutoDescripcionConvertDTO autoDescripcionConvertDTO;

    @Override
    public AutoDescripcionDTO crearAuto(AutoDescripcionDTO autoDescripcionDTO) {
        logger.info("Datos recibidos para crear AutoDescripcion: {}", autoDescripcionDTO);
        AutoDescripcion autoDescripcion = autoDescripcionConvertDTO.dtoToEntity(autoDescripcionDTO);
        autoDescripcionDao.crearAuto(autoDescripcion);
        logger.info("AutoDescripcion guardado con éxito: {}", autoDescripcion);
        return autoDescripcionConvertDTO.entityToDto(autoDescripcion);
    }

    @Override
    public AutoDescripcionDTO obtenerAuto(BigDecimal id) {
        AutoDescripcion autoDescripcion = autoDescripcionDao.obtenerAuto(id);
        if (autoDescripcion == null) {
            throw new RuntimeException("AutoDescripcion no encontrado con ID: " + id);
        }
        return autoDescripcionConvertDTO.entityToDto(autoDescripcion);
    }

    @Override
    public AutoDescripcionDTO actualizarAuto(BigDecimal id, AutoDescripcionDTO autoDescripcionDTO) {
        AutoDescripcion autoDescripcionExistente = autoDescripcionDao.obtenerAuto(id);
        if (autoDescripcionExistente == null) {
            throw new RuntimeException("AutoDescripcion no encontrado con ID: " + id);
        }
        AutoDescripcion autoDescripcionActualizado = autoDescripcionConvertDTO.dtoToEntity(autoDescripcionDTO);
        autoDescripcionActualizado.setiCatalogoAutoDescripcionId(id);
        autoDescripcionDao.actualizarAuto(autoDescripcionActualizado);
        return autoDescripcionConvertDTO.entityToDto(autoDescripcionActualizado);
    }

    @Override
    public List<AutoDescripcionDTO> listarAutos() {
        return autoDescripcionDao.listarAuto()
                .stream()
                .map(autoDescripcionConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        AutoDescripcion autoDescripcion = autoDescripcionDao.obtenerAuto(id);
        if (autoDescripcion == null) {
            throw new RuntimeException("AutoDescripcion no encontrado con ID: " + id);
        }
        autoDescripcionDao.eliminarAuto(id);
    }
}
