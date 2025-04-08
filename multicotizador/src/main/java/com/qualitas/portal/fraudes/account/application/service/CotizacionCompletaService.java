package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;

public interface CotizacionCompletaService {
    CotizacionCompletaResponseDTO crearCotizacionCompleta(PersonaDTO persona, AutoDTO auto, CatalogoDatos catalogo);
}
