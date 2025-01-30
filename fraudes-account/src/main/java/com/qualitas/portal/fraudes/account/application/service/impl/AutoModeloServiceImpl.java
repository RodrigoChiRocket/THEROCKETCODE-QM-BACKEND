package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.AutoModeloConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoModeloDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoModeloService;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoModeloServiceImpl implements AutoModeloService {

    private static final Logger logger = LoggerFactory.getLogger(AutoModeloServiceImpl.class);

    @Autowired
    private AutoModeloDao autoModeloDao;

    @Autowired
    private AutoModeloConvertDTO autoModeloConvertDTO;

    @Override
    public AutoModeloDTO crearAuto(AutoModeloDTO autoModeloDTO) {
        logger.info("Datos recibidos para crear AutoModelo: {}", autoModeloDTO);
        AutoModelo autoModelo = autoModeloConvertDTO.dtoToEntity(autoModeloDTO);
        autoModeloDao.crearAuto(autoModelo);
        logger.info("AutoModelo guardado con éxito: {}", autoModelo);
        return autoModeloConvertDTO.entityToDto(autoModelo);
    }

    @Override
    public AutoModeloDTO obtenerAuto(BigDecimal id) {
        AutoModelo autoModelo = autoModeloDao.obtenerAuto(id);
        if (autoModelo == null) {
            throw new RuntimeException("AutoModelo no encontrado con ID: " + id);
        }
        return autoModeloConvertDTO.entityToDto(autoModelo);
    }

    @Override
    public AutoModeloDTO actualizarAuto(BigDecimal id, AutoModeloDTO autoModeloDTO) {
        AutoModelo autoModeloExistente = autoModeloDao.obtenerAuto(id);
        if (autoModeloExistente == null) {
            throw new RuntimeException("AutoModelo no encontrado con ID: " + id);
        }
        AutoModelo autoModeloActualizado = autoModeloConvertDTO.dtoToEntity(autoModeloDTO);
        autoModeloActualizado.setiCatalogoAutoModeloId(id);
        autoModeloDao.actualizarAuto(autoModeloActualizado);
        return autoModeloConvertDTO.entityToDto(autoModeloActualizado);
    }

    @Override
    public List<AutoModeloDTO> listarAutos() {
        return autoModeloDao.listarAuto()
                .stream()
                .map(autoModeloConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        AutoModelo autoModelo = autoModeloDao.obtenerAuto(id);
        if (autoModelo == null) {
            throw new RuntimeException("AutoModelo no encontrado con ID: " + id);
        }
        autoModeloDao.eliminarAuto(id);
    }
}
