package com.qualitas.portal.fraudes.account.application.service.impl;


import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoDescripcionDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoMarcaDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.AutoModeloDao;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.service.AutoCotizacionService;
import com.qualitas.portal.fraudes.account.application.service.AutoService;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AutoCotizacionServiceImpl implements AutoCotizacionService {

    @Autowired
    private AutoMarcaDao autoMarcaDao;
    @Autowired
    private AutoModeloDao autoModeloDao;
    @Autowired
    private AutoDescripcionDao autoDescripcionDao;
    @Autowired
    private AutoService autoService;

    @Override
    public AutoDTO crearAutoDesdeCatalogo(CatalogoDatos catalogoDatos) {
        validarDatosAuto(catalogoDatos);

        AutoDTO autoDTO = construirAutoDTO(catalogoDatos);
        return autoService.crearAuto(autoDTO);
    }

    private void validarDatosAuto(CatalogoDatos catalogoDatos) {
        if(autoMarcaDao.obtenerAutoMarcaPorNombre(catalogoDatos.getMarca()) == null ||
                autoModeloDao.obtenerModeloPorNombre(catalogoDatos.getModelo()) == null ||
                autoDescripcionDao.obtenerAutoDescripcionPorNombre(catalogoDatos.getDescripcion()) == null) {
            throw new RuntimeException("Datos del auto incompletos o inválidos");
        }
    }

    private AutoDTO construirAutoDTO(CatalogoDatos catalogoDatos) {
        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setdAno(catalogoDatos.getAno());
        autoDTO.setiAutoMarcaClave(autoMarcaDao.obtenerAutoMarcaPorNombre(catalogoDatos.getMarca()).getiAutoMarcaId());
        autoDTO.setiAutoModeloClave(autoModeloDao.obtenerModeloPorNombre(catalogoDatos.getModelo()).getiAutoModeloId());
        autoDTO.setiAutoDescripcionClave(autoDescripcionDao.obtenerAutoDescripcionPorNombre(catalogoDatos.getDescripcion()).getiAutoDescripcionId());
        autoDTO.setiUsuarioCreacion(new BigDecimal(1));
        autoDTO.setdFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        return autoDTO;
    }
}