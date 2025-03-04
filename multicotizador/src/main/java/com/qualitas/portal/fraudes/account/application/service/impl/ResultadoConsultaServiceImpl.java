package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoConsultaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.ResultadoConsultaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.ResultadoConsultaDTO;
import com.qualitas.portal.fraudes.account.application.service.ResultadoConsultaService;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultadoConsultaServiceImpl implements ResultadoConsultaService {

    private static final Logger logger = LoggerFactory.getLogger(ResultadoConsultaServiceImpl.class);

    @Autowired
    private ResultadoConsultaDao resultadoConsultaDao;

    @Autowired
    private ResultadoConsultaConvertDTO resultadoConsultaConvertDTO;

    @Override
    public ResultadoConsultaDTO crearResultadoConsulta(ResultadoConsultaDTO resultadoConsultaDTO) {
        logger.info("Datos recibidos para crear ResultadoConsulta: {}", resultadoConsultaDTO);
        ResultadoConsulta resultadoConsulta = resultadoConsultaConvertDTO.dtoToEntity(resultadoConsultaDTO);
        resultadoConsultaDao.crearResultadoConsulta(resultadoConsulta);
        logger.info("ResultadoConsulta guardado con éxito en la base de datos: {}", resultadoConsulta);
        return resultadoConsultaConvertDTO.entityToDto(resultadoConsulta);
    }

    @Override
    public ResultadoConsultaDTO obtenerResultadoConsulta(BigDecimal id) {
        ResultadoConsulta resultadoConsulta = resultadoConsultaDao.obtenerResultadoConsulta(id);
        if (resultadoConsulta == null) {
            throw new RuntimeException("ResultadoConsulta no encontrado con ID: " + id);
        }
        return resultadoConsultaConvertDTO.entityToDto(resultadoConsulta);
    }

    @Override
    public ResultadoConsultaDTO actualizarResultadoConsulta(BigDecimal id, ResultadoConsultaDTO resultadoConsultaDTO) {
        ResultadoConsulta resultadoConsultaExistente = resultadoConsultaDao.obtenerResultadoConsulta(id);
        if (resultadoConsultaExistente == null) {
            throw new RuntimeException("ResultadoConsulta no encontrado con ID: " + id);
        }
        ResultadoConsulta resultadoConsultaActualizado = resultadoConsultaConvertDTO.dtoToEntity(resultadoConsultaDTO);
        resultadoConsultaActualizado.setiResultCargaId(id);
        resultadoConsultaDao.actualizarResultadoConsulta(resultadoConsultaActualizado);
        return resultadoConsultaConvertDTO.entityToDto(resultadoConsultaActualizado);
    }

    @Override
    public List<ResultadoConsultaDTO> listarResultadosConsulta() {
        return resultadoConsultaDao.listarResultadoConsulta()
                .stream()
                .map(resultadoConsultaConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarResultadoConsulta(BigDecimal id) {
        ResultadoConsulta resultadoConsulta = resultadoConsultaDao.obtenerResultadoConsulta(id);
        if (resultadoConsulta == null) {
            throw new RuntimeException("ResultadoConsulta no encontrado con ID: " + id);
        }
        resultadoConsultaDao.eliminarResultadoConsulta(id);
    }
}
