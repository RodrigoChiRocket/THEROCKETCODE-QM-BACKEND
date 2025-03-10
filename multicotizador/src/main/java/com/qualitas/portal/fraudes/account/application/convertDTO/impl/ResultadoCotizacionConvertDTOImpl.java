package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.ResultadoCotizacionConvertDTO;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.springframework.stereotype.Service;

@Service
public class ResultadoCotizacionConvertDTOImpl implements ResultadoCotizacionConvertDTO {

    @Override
    public ResultadoCotizacion dtoToEntity(ResultadoCotizacionDTO dto) {
        ResultadoCotizacion entity = new ResultadoCotizacion();
        entity.setiResultadoCotizacionId(dto.getiResultadoCotizacionId());
        entity.setiCotizacionClave(dto.getiCotizacionClave());
        entity.setvNombreSeguro(dto.getvNombreSeguro());
        entity.setvNombreCobertura(dto.getvNombreCobertura());
        entity.setdPrecioTotal(dto.getdPrecioTotal());
        entity.setvPlazoCobertura(dto.getvPlazoCobertura());
        entity.setdPrimerPago(dto.getdPrimerPago());
        entity.setdPagosResta(dto.getdPagosResta());
        entity.setiVigencia(dto.getiVigencia());
        entity.setdDanosTerceros(dto.getdDanosTerceros());
        entity.setiRoboTotal(dto.getiRoboTotal());
        entity.setiRoboParcial(dto.getiRoboParcial());
        entity.setdGastosMedicos(dto.getdGastosMedicos());
        entity.setiDanosLlanta(dto.getiDanosLlanta());
        entity.setiDanoCristal(dto.getiDanoCristal());
        entity.setiReposicionLlave(dto.getiReposicionLlave());
        entity.setbPerdidaTotal(dto.isbPerdidaTotal());
        entity.setdFallecimiento(dto.getdFallecimiento());
        entity.setbDefensaLegal(dto.isbDefensaLegal());
        entity.setbAsistencialVialCarretera(dto.isbAsistencialVialCarretera());
        entity.setiDanoVehiculo(dto.getiDanoVehiculo());
        entity.setdFechaCreacion(dto.getdFechaCreacion());
        return entity;
    }

    @Override
    public ResultadoCotizacionDTO entityToDto(ResultadoCotizacion entity) {
        ResultadoCotizacionDTO dto = new ResultadoCotizacionDTO();
        dto.setiResultadoCotizacionId(entity.getiResultadoCotizacionId());
        dto.setiCotizacionClave(entity.getiCotizacionClave());
        dto.setvNombreSeguro(entity.getvNombreSeguro());
        dto.setvNombreCobertura(entity.getvNombreCobertura());
        dto.setdPrecioTotal(entity.getdPrecioTotal());
        dto.setvPlazoCobertura(entity.getvPlazoCobertura());
        dto.setdPrimerPago(entity.getdPrimerPago());
        dto.setdPagosResta(entity.getdPagosResta());
        dto.setiVigencia(entity.getiVigencia());
        dto.setdDanosTerceros(entity.getdDanosTerceros());
        dto.setiRoboTotal(entity.getiRoboTotal());
        dto.setiRoboParcial(entity.getiRoboParcial());
        dto.setdGastosMedicos(entity.getdGastosMedicos());
        dto.setiDanosLlanta(entity.getiDanosLlanta());
        dto.setiDanoCristal(entity.getiDanoCristal());
        dto.setiReposicionLlave(entity.getiReposicionLlave());
        dto.setbPerdidaTotal(entity.isbPerdidaTotal());
        dto.setdFallecimiento(entity.getdFallecimiento());
        dto.setbDefensaLegal(entity.isbDefensaLegal());
        dto.setbAsistencialVialCarretera(entity.isbAsistencialVialCarretera());
        dto.setiDanoVehiculo(entity.getiDanoVehiculo());
        dto.setdFechaCreacion(entity.getdFechaCreacion());
        return dto;
    }
}