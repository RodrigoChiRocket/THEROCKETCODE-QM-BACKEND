package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoSeguroDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.TipoSeguroConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.TipoSeguroDTO;
import com.qualitas.portal.fraudes.account.application.service.TipoSeguroService;
import com.qualitas.portal.fraudes.account.domain.model.TipoSeguro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoSeguroServiceImpl implements TipoSeguroService {

    @Autowired
    private TipoSeguroDao tipoSeguroDao;

    @Autowired
    private TipoSeguroConvertDTO tipoSeguroConvertDTO;

    @Override
    public TipoSeguroDTO crearTipoSeguro(TipoSeguroDTO tipoSeguroDTO) {
        TipoSeguro tipoSeguro = tipoSeguroConvertDTO.dtoToEntity(tipoSeguroDTO);
        TipoSeguro tipoSeguroCreado = tipoSeguroDao.crearTipoSeguro(tipoSeguro);
        return tipoSeguroConvertDTO.entityToDto(tipoSeguroCreado);
    }

    @Override
    public TipoSeguroDTO obtenerTipoSeguro(BigDecimal id) {
        TipoSeguro tipoSeguro = tipoSeguroDao.obtenerTipoSeguro(id);
        return tipoSeguroConvertDTO.entityToDto(tipoSeguro);
    }

    @Override
    public TipoSeguroDTO actualizarTipoSeguro(BigDecimal id, TipoSeguroDTO tipoSeguroDTO) {
        TipoSeguro tipoSeguro = tipoSeguroConvertDTO.dtoToEntity(tipoSeguroDTO);
        tipoSeguro.setlTipoSeguroId(id);
        TipoSeguro tipoSeguroActualizado = tipoSeguroDao.actualizarTipoSeguro(tipoSeguro);
        return tipoSeguroConvertDTO.entityToDto(tipoSeguroActualizado);
    }

    @Override
    public List<TipoSeguroDTO> listarTiposSeguro() {
        return tipoSeguroDao.listarTiposSeguro().stream()
                .map(tipoSeguroConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTipoSeguro(BigDecimal id) {
        tipoSeguroDao.eliminarTipoSeguro(id);
    }

    @Override
    public TipoSeguro obtenerTipoSeguroPorNombre(String vNombre) {
        return tipoSeguroDao.obtenerTipoSeguroPorNombre(vNombre);
    }
}