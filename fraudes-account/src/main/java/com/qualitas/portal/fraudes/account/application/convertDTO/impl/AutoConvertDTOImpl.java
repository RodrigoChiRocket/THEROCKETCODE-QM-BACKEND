package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.AutoConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.Auto;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AutoConvertDTOImpl implements AutoConvertDTO {

    private static final Logger logger = LoggerFactory.getLogger(AutoConvertDTOImpl.class);

    @Override
    public Auto dtoToEntity(AutoDTO autoDTO) {
        logger.info("Convirtiendo AutoDTO a Auto: {}", autoDTO);
        Auto auto = new Auto();
        auto.setiAutoId(autoDTO.getiAutoId());
        auto.setvDescripcion(autoDTO.getvDescripcion());
        auto.setdFechaCreacion(autoDTO.getdFechaCreacion());
        auto.setiUsuarioCreacion(autoDTO.getiUsuarioCreacion());

        return auto;
    }

    @Override
    public AutoDTO entityToDto(Auto auto) {
        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setiAutoId(auto.getiAutoId());
        autoDTO.setvDescripcion(auto.getvDescripcion());
        autoDTO.setdFechaCreacion(auto.getdFechaCreacion());
        autoDTO.setiUsuarioCreacion(auto.getiUsuarioCreacion());
        return autoDTO;
    }
}
