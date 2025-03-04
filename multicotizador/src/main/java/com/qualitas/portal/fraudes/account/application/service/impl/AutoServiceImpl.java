package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoMarcaDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.AutoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoService;
import com.qualitas.portal.fraudes.account.domain.model.Auto;
import com.qualitas.portal.fraudes.account.domain.model.AutoDescripcion;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;
import com.qualitas.portal.fraudes.account.domain.model.AutoModelo;
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
    private AutoMarcaDao autoMarcaDao;

    @Autowired
    private AutoModeloDao autoModeloDao;

    @Autowired
    private AutoDescripcionDao autoDescripcionDao;

    @Autowired
    private AutoConvertDTO autoConvertDTO;

    @Override
    public AutoDTO crearAuto(AutoDTO autoDTO) {
        logger.info("Datos recibidos para crear Auto: {}", autoDTO);
        logger.info("iAutoDescripcionClave recibido: {}", autoDTO.getiAutoDescripcionClave()); // Log del valor recibido
        Auto auto = autoConvertDTO.dtoToEntity(autoDTO);
        logger.info("iAutoDescripcionClave antes de guardar: {}", auto.getiAutoDescripcionClave()); // Log del valor antes de guardar
        autoDAO.crearAuto(auto);
        logger.info("Auto guardado con éxito en la base de datos: {}", auto);

        AutoMarca autoMarca= autoMarcaDao.obtenerAutoMarca(autoDTO.getiAutoMarcaClave());
        AutoModelo autoModelo = autoModeloDao.obtenerAuto(autoDTO.getiAutoModeloClave());
        AutoDescripcion autoDescripcion = autoDescripcionDao.obtenerAuto(autoDTO.getiAutoDescripcionClave());

        AutoDTO autoDTO1= autoConvertDTO.entityToDto(auto);

        autoDTO1.setvNombreMarca(autoMarca.getvNombre());
        autoDTO1.setvNombreModelo(autoModelo.getvNombre());
        autoDTO1.setvNombreDescripcion(autoDescripcion.getvNombre());



        return autoDTO1;
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
