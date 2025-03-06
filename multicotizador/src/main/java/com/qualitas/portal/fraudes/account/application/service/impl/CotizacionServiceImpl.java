package com.qualitas.portal.fraudes.account.application.service.impl;


import com.qualitas.portal.fraudes.account.Infrastructure.dao.CotizacionDao;
import com.qualitas.portal.fraudes.account.application.dto.*;
import com.qualitas.portal.fraudes.account.application.dto.request.CotizacionCompletaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.*;
import com.qualitas.portal.fraudes.account.domain.model.Cotizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private AutoService autoService;
    @Autowired
    private TipoAutoService tipoAutoService;
    @Autowired
    private CategoriaVehiculoService categoriaVehiculoService;
    @Autowired
    private UsoService usoService;
    @Autowired
    private TipoSeguroService tipoSeguroService;


    @Autowired
    private CotizacionDao cotizacionDao;

    // Convertir de DTO a Model
    private Cotizacion convertToModel(CotizacionDTO dto) {
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setiCotizacionId(dto.getiCotizacionId());
        cotizacion.setiCategoriaVehiculoClave(dto.getiCategoriaVehiculoClave());
        cotizacion.setiTipoSeguroClave(dto.getiTipoSeguroClave());
        cotizacion.setiUsoClave(dto.getiUsoClave());
        cotizacion.setiTipoAutoClave(dto.getiTipoAutoClave());
        cotizacion.setiAutoClave(dto.getiAutoClave());
        cotizacion.setiPersonaClave(dto.getiPersonaClave());
        cotizacion.setdFechaCreacion(dto.getdFechaCreacion());
        cotizacion.setiUsuarioCreacion(dto.getiUsuarioCreacion());
        return cotizacion;
    }

    // Convertir de Model a DTO



    @Override
    public CotizacionCompletaResponseDTO crearCotizacionCompleta(CotizacionCompletaDTO cotizacionCompletaDTO) {
        // Obtener los nombres de las entidades relacionadas
        UsoDTO usoDTO = usoService.obtenerUso(cotizacionCompletaDTO.getCotizacion().getiUsoClave());
        CategoriaVehiculoDTO categoriaVehiculoDTO = categoriaVehiculoService.obtenerCategoriaVehiculo(cotizacionCompletaDTO.getCotizacion().getiCategoriaVehiculoClave());
        TipoSeguroDTO tipoSeguroDTO = tipoSeguroService.obtenerTipoSeguro(cotizacionCompletaDTO.getCotizacion().getiTipoSeguroClave());
        TipoAutoDTO tipoAutoDTO = tipoAutoService.obtenerTipoAuto(cotizacionCompletaDTO.getCotizacion().getiTipoAutoClave());



        // 1. Crear la Persona
        PersonaDTO personaDTO = cotizacionCompletaDTO.getPersona();
        PersonaDTO personaCreada = personaService.crearPersona(personaDTO);
        BigDecimal personaId = personaCreada.getiPersonaId();

        // 2. Crear el Auto
        AutoDTO autoDTO = cotizacionCompletaDTO.getAuto();
        AutoDTO autoCreado = autoService.crearAuto(autoDTO);
        BigDecimal autoId = autoCreado.getiAutoId();

        // 3. Crear la Cotización con los IDs de Persona y Auto
        CotizacionDTO cotizacionDTO = cotizacionCompletaDTO.getCotizacion();
        cotizacionDTO.setiPersonaClave(personaId);
        cotizacionDTO.setiAutoClave(autoId);
        cotizacionDTO.setvNombreUso(usoDTO.getvNombre());
        cotizacionDTO.setvNombreCategoriaVehiculo(categoriaVehiculoDTO.getvNombre());
        cotizacionDTO.setvNombreTipoSeguro(tipoSeguroDTO.getvNombre());
        cotizacionDTO.setvNombreTipoAUto(tipoAutoDTO.getvNombre());

        // 4. Crear la Cotización
        Cotizacion cotizacion = convertToModel(cotizacionDTO);
        cotizacionDao.crearCotizacion(cotizacion);
        CotizacionDTO cotizacionCreada = convertToDTO(cotizacion);

        // Asignar los nombres al CotizacionDTO creado
        cotizacionCreada.setvNombreUso(usoDTO.getvNombre());
        cotizacionCreada.setvNombreCategoriaVehiculo(categoriaVehiculoDTO.getvNombre());
        cotizacionCreada.setvNombreTipoSeguro(tipoSeguroDTO.getvNombre());
        cotizacionCreada.setvNombreTipoAUto(tipoAutoDTO.getvNombre());

        // 5. Crear y devolver el DTO de respuesta
        CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
        responseDTO.setPersona(personaCreada);
        responseDTO.setAuto(autoCreado);
        responseDTO.setCotizacion(cotizacionCreada);

        return responseDTO;
    }

    // Convertir de Model a DTO
    private CotizacionDTO convertToDTO(Cotizacion cotizacion) {
        CotizacionDTO dto = new CotizacionDTO();
        dto.setiCotizacionId(cotizacion.getiCotizacionId());
        dto.setiCategoriaVehiculoClave(cotizacion.getiCategoriaVehiculoClave());
        dto.setiTipoSeguroClave(cotizacion.getiTipoSeguroClave());
        dto.setiUsoClave(cotizacion.getiUsoClave());
        dto.setiTipoAutoClave(cotizacion.getiTipoAutoClave());
        dto.setiAutoClave(cotizacion.getiAutoClave());
        dto.setiPersonaClave(cotizacion.getiPersonaClave());
        dto.setdFechaCreacion(cotizacion.getdFechaCreacion());
        dto.setiUsuarioCreacion(cotizacion.getiUsuarioCreacion());
        return dto;
    }
    @Override
    public CotizacionDTO crearCotizacion(CotizacionDTO cotizacionDTO) {
        Cotizacion cotizacion = convertToModel(cotizacionDTO);
        cotizacionDao.crearCotizacion(cotizacion);
        return convertToDTO(cotizacion);
    }

    @Override
    public CotizacionDTO obtenerCotizacionPorId(BigDecimal id) {
        Cotizacion cotizacion = cotizacionDao.obtenerCotizacionPorId(id);
        return convertToDTO(cotizacion);
    }

    @Override
    public CotizacionDTO actualizarCotizacion(CotizacionDTO cotizacionDTO) {
        Cotizacion cotizacion = convertToModel(cotizacionDTO);
        cotizacionDao.actualizarCotizacion(cotizacion);
        return convertToDTO(cotizacion);
    }

    @Override
    public void eliminarCotizacion(BigDecimal id) {
        cotizacionDao.eliminarCotizacion(id);
    }

    @Override
    public List<CotizacionDTO> listarTodasLasCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionDao.listarTodasLasCotizaciones();
        return cotizaciones.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}