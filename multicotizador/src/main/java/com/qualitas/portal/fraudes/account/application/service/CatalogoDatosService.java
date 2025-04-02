package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import com.qualitas.portal.fraudes.account.domain.model.Persona;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface CatalogoDatosService {
    List<CatalogoDatos> procesarCatalogoExcel(MultipartFile archivo);
    CotizacionCompletaResponseDTO crearCotizacionCompletaDesdeCatalogo(CatalogoDatos catalogoDatos);

}