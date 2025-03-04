package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.UsoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.UsoDTO;
import com.qualitas.portal.fraudes.account.domain.model.Uso;
import org.springframework.stereotype.Service;

@Service
public class UsoConvertDTOImpl implements UsoConvertDTO {

    @Override
    public UsoDTO entityToDto(Uso uso) {
        UsoDTO usoDTO = new UsoDTO();
        usoDTO.setiUsoId(uso.getiUsoId());
        usoDTO.setvNombre(uso.getvNombre());
        usoDTO.setdFechaCreacion(uso.getdFechaCreacion());
        return usoDTO;
    }

    @Override
    public Uso dtoToEntity(UsoDTO usoDTO) {
        Uso uso = new Uso();
        uso.setiUsoId(usoDTO.getiUsoId());
        uso.setvNombre(usoDTO.getvNombre());
        uso.setdFechaCreacion(usoDTO.getdFechaCreacion());
        return uso;
    }
}