package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;

public interface PersonaCotizacionService {
    PersonaDTO crearPersonaDesdeCatalogo(CatalogoDatos catalogoDatos);
}
