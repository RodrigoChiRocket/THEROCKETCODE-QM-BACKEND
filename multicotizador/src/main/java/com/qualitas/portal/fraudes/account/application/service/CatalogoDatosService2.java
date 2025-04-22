package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public interface CatalogoDatosService2 {

    CotizacionCompletaResponseDTO crearCotizacionCompletaDesdeCatalogo(CatalogoDatos catalogoDatos);
    List<CatalogoDatos> procesarCatalogoExcel(MultipartFile archivo);

    boolean verificarCotizacionesCompletadas(BigDecimal rutinaCargaClave);
}

