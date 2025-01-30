package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.AutoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoService;
import com.qualitas.portal.fraudes.account.domain.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImpl implements AutoService {

    private static final Logger logger = LoggerFactory.getLogger(AutoServiceImpl.class);

    @Autowired
    private AutoDao autoDAO;

    @Autowired
    private AutoConvertDTO autoConvertDTO;

    @Override
    public AutoDTO crearAuto(AutoDTO autoDTO) {
        logger.info("Datos recibidos para crear Auto: {}", autoDTO);
        Auto auto = autoConvertDTO.dtoToEntity(autoDTO);
        autoDAO.crearAuto(auto);
        logger.info("Auto guardado con éxito en la base de datos: {}", auto);
        return autoConvertDTO.entityToDto(auto);
    }

    @Override
    public AutoDTO obtenerAuto(BigDecimal id) {
        Auto auto = autoDAO.obtenerAuto(id);
        if (auto == null) {
            throw new RuntimeException("Auto no encontrado con ID: " + id);
        }
        return autoConvertDTO.entityToDto(auto);
    }

    @Override
    public AutoDTO actualizarAuto(BigDecimal id, AutoDTO autoDTO) {
        Auto autoExistente = autoDAO.obtenerAuto(id);
        if (autoExistente == null) {
            throw new RuntimeException("Auto no encontrado con ID: " + id);
        }
        Auto autoActualizado = autoConvertDTO.dtoToEntity(autoDTO);
        autoActualizado.setiAutoId(id);
        autoDAO.actualizarAuto(autoActualizado);
        return autoConvertDTO.entityToDto(autoActualizado);
    }

    @Override
    public List<AutoDTO> listarAutos() {
        return autoDAO.listarAuto()
                .stream()
                .map(autoConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAuto(BigDecimal id) {
        Auto auto = autoDAO.obtenerAuto(id);
        if (auto == null) {
            throw new RuntimeException("Auto no encontrado con ID: " + id);
        }
        autoDAO.eliminarAuto(id);
    }
}
