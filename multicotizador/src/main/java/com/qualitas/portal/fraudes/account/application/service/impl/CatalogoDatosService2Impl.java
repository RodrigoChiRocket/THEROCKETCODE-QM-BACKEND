package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.*;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class CatalogoDatosService2Impl implements CatalogoDatosService2 {

    @Autowired
    private PersonaCotizacionService personaCotizacionService;
    @Autowired
    private AutoCotizacionService autoCotizacionService;
    @Autowired
    private CotizacionCompletaService cotizacionCompletaService;
    @Autowired
    private ExcelProcessorService excelProcessorService;

    @Override
    public CotizacionCompletaResponseDTO crearCotizacionCompletaDesdeCatalogo(CatalogoDatos catalogoDatos) {
        PersonaDTO persona = personaCotizacionService.crearPersonaDesdeCatalogo(catalogoDatos);
        AutoDTO auto = autoCotizacionService.crearAutoDesdeCatalogo(catalogoDatos);
        return cotizacionCompletaService.crearCotizacionCompleta(persona, auto, catalogoDatos);
    }

    @Override
    public List<CatalogoDatos> procesarCatalogoExcel(MultipartFile archivo) {
        return excelProcessorService.procesarArchivoExcel(archivo);
    }

}
