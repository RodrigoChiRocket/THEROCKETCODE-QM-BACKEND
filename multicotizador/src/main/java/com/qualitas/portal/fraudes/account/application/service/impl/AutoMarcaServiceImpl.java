package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoMarcaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.AutoMarcaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoMarcaDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoMarcaService;
import com.qualitas.portal.fraudes.account.domain.model.AutoMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoMarcaServiceImpl implements AutoMarcaService {

    @Autowired
    private AutoMarcaDao autoMarcaDao;

    @Autowired
    private AutoMarcaConvertDTO autoMarcaConvertDTO;

    @Override
    public AutoMarcaDTO crearAutoMarca(AutoMarcaDTO autoMarcaDTO) {
        AutoMarca autoMarca = autoMarcaConvertDTO.dtoToEntity(autoMarcaDTO);
        AutoMarca autoMarcaCreada = autoMarcaDao.crearAutoMarca(autoMarca);
        return autoMarcaConvertDTO.entityToDto(autoMarcaCreada);
    }

    @Override
    public AutoMarcaDTO obtenerAutoMarca(BigDecimal id) {
        AutoMarca autoMarca = autoMarcaDao.obtenerAutoMarca(id);
        return autoMarcaConvertDTO.entityToDto(autoMarca);
    }

    @Override
    public AutoMarcaDTO actualizarAutoMarca(BigDecimal id, AutoMarcaDTO autoMarcaDTO) {
        AutoMarca autoMarca = autoMarcaConvertDTO.dtoToEntity(autoMarcaDTO);
        autoMarca.setiAutoMarcaId(id);
        AutoMarca autoMarcaActualizada = autoMarcaDao.actualizarAutoMarca(autoMarca);
        return autoMarcaConvertDTO.entityToDto(autoMarcaActualizada);
    }

    @Override
    public List<AutoMarcaDTO> listarAutoMarcas() {
        return autoMarcaDao.listarAutoMarcas().stream()
                .map(autoMarcaConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAutoMarca(BigDecimal id) {
        autoMarcaDao.eliminarAutoMarca(id);
    }
}