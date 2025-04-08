package com.qualitas.portal.fraudes.account.application.service.impl;


import com.qualitas.portal.fraudes.account.Infrastructure.dao.CategoriaVehiculoDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.TipoAutoDao;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.CotizacionCompletaService;
import com.qualitas.portal.fraudes.account.application.service.CotizacionService;
import com.qualitas.portal.fraudes.account.application.service.UsoService;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import com.qualitas.portal.fraudes.account.domain.model.CategoriaVehiculo;
import com.qualitas.portal.fraudes.account.domain.model.TipoAuto;
import com.qualitas.portal.fraudes.account.domain.model.Uso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CotizacionCompletaServiceImpl implements CotizacionCompletaService {

    @Autowired
    private CategoriaVehiculoDao categoriaVehiculoDao;
    @Autowired
    private TipoAutoDao tipoAutoDao;
    @Autowired
    private UsoService usoService;
    @Autowired
    private CotizacionService cotizacionService;

    @Override
    public CotizacionCompletaResponseDTO crearCotizacionCompleta(PersonaDTO persona, AutoDTO auto, CatalogoDatos catalogo) {
        validarDatosCotizacion(catalogo);

        CotizacionDTO cotizacionDTO = construirCotizacionDTO(persona, auto, catalogo);
        cotizacionDTO = cotizacionService.crearCotizacionCatalogo(cotizacionDTO);

        return construirRespuestaCompleta(persona, auto, cotizacionDTO, catalogo);
    }

    private void validarDatosCotizacion(CatalogoDatos catalogo) {
        if(categoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre(catalogo.getCategoriaVehiculo()) == null ||
                tipoAutoDao.obtenerTipoAutoPorNombre(catalogo.getTipoVehiculo()) == null ||
                usoService.obtenerUsoPorNombre(catalogo.getUso()) == null) {
            throw new RuntimeException("Datos de cotización incompletos");
        }
    }

    private CotizacionDTO construirCotizacionDTO(PersonaDTO persona, AutoDTO auto, CatalogoDatos catalogo) {
        CotizacionDTO cotizacionDTO = new CotizacionDTO();

        // Obtener entidades relacionadas
        CategoriaVehiculo categoria = categoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre(catalogo.getCategoriaVehiculo());
        TipoAuto tipoAuto = tipoAutoDao.obtenerTipoAutoPorNombre(catalogo.getTipoVehiculo());
        Uso uso = usoService.obtenerUsoPorNombre(catalogo.getUso());

        // Validar que existen
        if (categoria == null || tipoAuto == null || uso == null) {
            throw new RuntimeException("Datos de referencia no encontrados para crear la cotización");
        }

        // Configurar cotización
        cotizacionDTO.setiTipoAutoClave(tipoAuto.getlTipoAutoId());
        cotizacionDTO.setiCategoriaVehiculoClave(categoria.getlCategoriaVehiculoId());
        cotizacionDTO.setiUsoClave(uso.getiUsoId());
        cotizacionDTO.setiAutoClave(auto.getiAutoId());
        cotizacionDTO.setiPersonaClave(persona.getiPersonaId());
        cotizacionDTO.setdFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        cotizacionDTO.setiTipoSeguroClave(new BigDecimal(1)); // Valor por defecto
        cotizacionDTO.setiUsuarioCreacion("SISTEMA"); // Usuario por defecto

        return cotizacionDTO;
    }

    private CotizacionCompletaResponseDTO construirRespuestaCompleta(PersonaDTO persona, AutoDTO auto,
                                                                     CotizacionDTO cotizacion, CatalogoDatos catalogo) {
        CotizacionCompletaResponseDTO response = new CotizacionCompletaResponseDTO();

        // Obtener entidades relacionadas para nombres descriptivos
        CategoriaVehiculo categoria = categoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre(catalogo.getCategoriaVehiculo());
        TipoAuto tipoAuto = tipoAutoDao.obtenerTipoAutoPorNombre(catalogo.getTipoVehiculo());
        Uso uso = usoService.obtenerUsoPorNombre(catalogo.getUso());

        // Configurar nombres descriptivos en la cotización
        cotizacion.setvNombreCategoriaVehiculo(categoria != null ? categoria.getvNombre() : "N/A");
        cotizacion.setvNombreTipoAUto(tipoAuto != null ? tipoAuto.getvNombre() : "N/A");
        cotizacion.setvNombreUso(uso != null ? uso.getvNombre() : "N/A");
        cotizacion.setvNombreTipoSeguro("Seguro Anual"); // Valor por defecto

        // Construir respuesta completa
        response.setCotizacion(cotizacion);
        response.setAuto(auto);
        response.setPersona(persona);


        return response;
    }
}