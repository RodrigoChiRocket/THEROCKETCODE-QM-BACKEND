package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.TipoAutoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.TipoAutoDTO;
import com.qualitas.portal.fraudes.account.application.service.TipoAutoService;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoAutoServiceImpl implements TipoAutoService {

    @Autowired
    private TipoAutoDao tipoAutoDao;

    @Autowired
    private TipoAutoConvertDTO tipoAutoConvertDTO;

    @Override
    public TipoAutoDTO crearTipoAuto(TipoAutoDTO tipoAutoDTO) {
        TipoAuto tipoAuto = tipoAutoConvertDTO.dtoToEntity(tipoAutoDTO);
        TipoAuto tipoAutoCreado = tipoAutoDao.crearTipoAuto(tipoAuto);
        return tipoAutoConvertDTO.entityToDto(tipoAutoCreado);
    }

    @Override
    public TipoAutoDTO obtenerTipoAuto(BigDecimal id) {
        TipoAuto tipoAuto = tipoAutoDao.obtenerTipoAuto(id);
        return tipoAutoConvertDTO.entityToDto(tipoAuto);
    }

    @Override
    public TipoAutoDTO actualizarTipoAuto(BigDecimal id, TipoAutoDTO tipoAutoDTO) {
        TipoAuto tipoAuto = tipoAutoConvertDTO.dtoToEntity(tipoAutoDTO);
        tipoAuto.setlTipoAutoId(id);
        TipoAuto tipoAutoActualizado = tipoAutoDao.actualizarTipoAuto(tipoAuto);
        return tipoAutoConvertDTO.entityToDto(tipoAutoActualizado);
    }

    @Override
    public List<TipoAutoDTO> listarTiposAuto() {
        return tipoAutoDao.listarTiposAuto().stream()
                .map(tipoAutoConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTipoAuto(BigDecimal id) {
        tipoAutoDao.eliminarTipoAuto(id);
    }

    @Override
    public TipoAuto obtenerTipoAutoPorNombre(String vNombre) {
        return tipoAutoDao.obtenerTipoAutoPorNombre(vNombre);
    }
}