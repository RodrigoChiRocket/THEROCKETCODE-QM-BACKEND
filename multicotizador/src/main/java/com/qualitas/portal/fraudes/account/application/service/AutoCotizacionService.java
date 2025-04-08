package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;

public interface AutoCotizacionService {
    AutoDTO crearAutoDesdeCatalogo(CatalogoDatos catalogoDatos);
}
