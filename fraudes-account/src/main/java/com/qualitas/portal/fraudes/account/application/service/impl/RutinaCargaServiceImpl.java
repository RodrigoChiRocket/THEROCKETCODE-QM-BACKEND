package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RutinaCargaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.RutinaCargaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.RutinaCargaDTO;
import com.qualitas.portal.fraudes.account.application.service.RutinaCargaService;
import com.qualitas.portal.fraudes.account.domain.model.RutinaCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
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
        return rutinaCargaDao.listarRutinas()
                .stream()
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
}
