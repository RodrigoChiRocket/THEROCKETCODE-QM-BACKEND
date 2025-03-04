package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsoDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.UsoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.UsoDTO;
import com.qualitas.portal.fraudes.account.application.service.UsoService;
import com.qualitas.portal.fraudes.account.domain.model.Uso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsoServiceImpl implements UsoService {

    @Autowired
    private UsoDao usoDao;

    @Autowired
    private UsoConvertDTO usoConvertDTO;

    @Override
    public UsoDTO crearUso(UsoDTO usoDTO) {
        Uso uso = usoConvertDTO.dtoToEntity(usoDTO);
        Uso usoCreado = usoDao.crearUso(uso);
        return usoConvertDTO.entityToDto(usoCreado);
    }

    @Override
    public UsoDTO obtenerUso(BigDecimal id) {
        Uso uso = usoDao.obtenerUso(id);
        return usoConvertDTO.entityToDto(uso);
    }

    @Override
    public UsoDTO actualizarUso(BigDecimal id, UsoDTO usoDTO) {
        Uso uso = usoConvertDTO.dtoToEntity(usoDTO);
        uso.setiUsoId(id);
        Uso usoActualizado = usoDao.actualizarUso(uso);
        return usoConvertDTO.entityToDto(usoActualizado);
    }

    @Override
    public List<UsoDTO> listarUsos() {
        return usoDao.listarUsos().stream()
                .map(usoConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarUso(BigDecimal id) {
        usoDao.eliminarUso(id);
    }
}