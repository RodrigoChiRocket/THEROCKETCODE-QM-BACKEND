package com.qualitas.portal.fraudes.account.application.service.impl;


import com.qualitas.portal.fraudes.account.Infrastructure.dao.CotizacionDao;
import com.qualitas.portal.fraudes.account.application.dto.*;
import com.qualitas.portal.fraudes.account.application.dto.request.CotizacionCompletaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.*;
import com.qualitas.portal.fraudes.account.domain.model.Cotizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
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
    private AutoModeloService autoModeloService;
    @Autowired
    private AutoDescripcionService autoDescripcionService;
    @Autowired
    private AutoMarcaService autoMarcaService;


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
    public CotizacionCompletaResponseDTO crearCotizacionCompletaCatalogo(CotizacionCompletaDTO cotizacionCompletaDTO) {
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
        cotizacionDao.crearCotizacionCatalogo(cotizacion);
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
    public CotizacionDTO crearCotizacionCatalogo(CotizacionDTO cotizacionDTO) {
        Cotizacion cotizacion = convertToModel(cotizacionDTO);
        cotizacionDao.crearCotizacionCatalogo(cotizacion);
        return convertToDTO(cotizacion);
    }

    @Override
    public CotizacionDTO obtenerCotizacionPorId(BigDecimal id) {
        Cotizacion cotizacion = cotizacionDao.obtenerCotizacionPorId(id);
        return convertToDTO(cotizacion);
    }

    @Override
    public CotizacionDTO actualizarCotizacion(BigDecimal id, CotizacionDTO cotizacionDTO) {
        try {
            // 1. Verificar existencia de la cotización
            Cotizacion cotizacionExistente = cotizacionDao.obtenerCotizacionPorId(id);
            if (cotizacionExistente == null) {
                throw new RuntimeException("Cotización no encontrada con ID: " + id);
            }

            // 2. Convertir DTO a entidad
            Cotizacion cotizacionActualizada = convertToModel(cotizacionDTO);
            cotizacionActualizada.setiCotizacionId(id);

            // 3. FORZAR a mantener los valores existentes de persona y auto
            cotizacionActualizada.setiPersonaClave(cotizacionExistente.getiPersonaClave());
            cotizacionActualizada.setiAutoClave(cotizacionExistente.getiAutoClave());

            // 4. Mantener otros valores existentes si no se proporcionan en el DTO
            if (cotizacionActualizada.getiCategoriaVehiculoClave() == null) {
                cotizacionActualizada.setiCategoriaVehiculoClave(cotizacionExistente.getiCategoriaVehiculoClave());
            }
            if (cotizacionActualizada.getiTipoSeguroClave() == null) {
                cotizacionActualizada.setiTipoSeguroClave(cotizacionExistente.getiTipoSeguroClave());
            }
            if (cotizacionActualizada.getiUsoClave() == null) {
                cotizacionActualizada.setiUsoClave(cotizacionExistente.getiUsoClave());
            }
            if (cotizacionActualizada.getiTipoAutoClave() == null) {
                cotizacionActualizada.setiTipoAutoClave(cotizacionExistente.getiTipoAutoClave());
            }
            if (cotizacionActualizada.getdFechaCreacion() == null) {
                cotizacionActualizada.setdFechaCreacion(cotizacionExistente.getdFechaCreacion());
            }
            if (cotizacionActualizada.getiUsuarioCreacion() == null) {
                cotizacionActualizada.setiUsuarioCreacion(cotizacionExistente.getiUsuarioCreacion());
            }

            // Mantener el flag de catálogo si existe
            if (cotizacionExistente.getbCatalogoDato() != null) {
                cotizacionActualizada.setbCatalogoDato(cotizacionExistente.getbCatalogoDato());
            }

            // 5. Actualizar en BD (como catálogo en este caso)
            cotizacionActualizada.setbCatalogoDato(1);
            cotizacionDao.actualizarCotizacionCatalogo(cotizacionActualizada);

            // 6. Obtener datos actualizados con relaciones
            Cotizacion cotizacionActualizadaDB = cotizacionDao.obtenerCotizacionPorId(id);
            CotizacionDTO responseDTO = convertToDTO(cotizacionActualizadaDB);

            // Obtener nombres de relaciones
            UsoDTO usoDTO = usoService.obtenerUso(cotizacionActualizadaDB.getiUsoClave());
            CategoriaVehiculoDTO categoriaVehiculoDTO = categoriaVehiculoService
                    .obtenerCategoriaVehiculo(cotizacionActualizadaDB.getiCategoriaVehiculoClave());
            TipoSeguroDTO tipoSeguroDTO = tipoSeguroService
                    .obtenerTipoSeguro(cotizacionActualizadaDB.getiTipoSeguroClave());
            TipoAutoDTO tipoAutoDTO = tipoAutoService
                    .obtenerTipoAuto(cotizacionActualizadaDB.getiTipoAutoClave());

            responseDTO.setvNombreUso(usoDTO.getvNombre());
            responseDTO.setvNombreCategoriaVehiculo(categoriaVehiculoDTO.getvNombre());
            responseDTO.setvNombreTipoSeguro(tipoSeguroDTO.getvNombre());
            responseDTO.setvNombreTipoAUto(tipoAutoDTO.getvNombre());

            return responseDTO;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la cotización: " + e.getMessage(), e);
        }
    }
    @Transactional
    @Override
    public CotizacionCompletaResponseDTO actualizarCotizacionCompleta(BigDecimal cotizacionId, CotizacionCompletaDTO requestDTO) {
        try {


            // 1. Obtener y validar cotización existente
            Cotizacion cotizacionExistente = cotizacionDao.obtenerCotizacionPorId(cotizacionId);
            if (cotizacionExistente == null) {
                throw new RuntimeException("Cotización no encontrada con ID: " + cotizacionId);
            }

            // 2. Actualizar Persona
            PersonaDTO personaActualizada = null;
            if (requestDTO.getPersona() != null) {
                personaActualizada = personaService.actualizarPersona(
                        cotizacionExistente.getiPersonaClave(),
                        requestDTO.getPersona()
                );
            } else {
                personaActualizada = personaService.obtenerPersona(cotizacionExistente.getiPersonaClave());
            }

            // 3. Actualizar Auto
            AutoDTO autoActualizado = null;
            if (requestDTO.getAuto() != null) {
                autoActualizado = autoService.actualizarAuto(
                        cotizacionExistente.getiAutoClave(),
                        requestDTO.getAuto()
                );
            } else {
                autoActualizado = autoService.obtenerAuto(cotizacionExistente.getiAutoClave());
            }

            // 4. Actualizar Cotización
            CotizacionDTO cotizacionActualizada = null;
            if (requestDTO.getCotizacion() != null) {
                requestDTO.getCotizacion().setiCotizacionId(cotizacionId);
                cotizacionActualizada = this.actualizarCotizacion(cotizacionId, requestDTO.getCotizacion());
            } else {
                cotizacionActualizada = this.obtenerCotizacionPorId(cotizacionId);
            }





            // 5. Obtener datos adicionales para la respuesta
            UsoDTO usoDTO = usoService.obtenerUso(cotizacionActualizada.getiUsoClave());
            CategoriaVehiculoDTO categoriaVehiculoDTO = categoriaVehiculoService
                    .obtenerCategoriaVehiculo(cotizacionActualizada.getiCategoriaVehiculoClave());
            TipoSeguroDTO tipoSeguroDTO = tipoSeguroService
                    .obtenerTipoSeguro(cotizacionActualizada.getiTipoSeguroClave());
            TipoAutoDTO tipoAutoDTO = tipoAutoService
                    .obtenerTipoAuto(cotizacionActualizada.getiTipoAutoClave());

            cotizacionActualizada.setvNombreUso(usoDTO.getvNombre());
            cotizacionActualizada.setvNombreCategoriaVehiculo(categoriaVehiculoDTO.getvNombre());
            cotizacionActualizada.setvNombreTipoSeguro(tipoSeguroDTO.getvNombre());
            cotizacionActualizada.setvNombreTipoAUto(tipoAutoDTO.getvNombre());

            // 6. Construir y retornar respuesta
            CotizacionCompletaResponseDTO response = new CotizacionCompletaResponseDTO();
            response.setPersona(personaActualizada);
            response.setAuto(autoActualizado);
            response.setCotizacion(cotizacionActualizada);

            return response;

        } catch (Exception e) {

            throw new RuntimeException("Error al actualizar cotización completa: " + e.getMessage(), e);
        }
    }



    @Transactional
    public void eliminarCotizacion(BigDecimal id) {
        // 1. Elimina resultados relacionados
        cotizacionDao.eliminarResultadosRelacionados(id);
        // 2. Elimina la cotización principal
        cotizacionDao.eliminarCotizacion(id);
    }

    @Override
    public List<CotizacionCompletaResponseDTO> listarTodasLasCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionDao.listarTodasLasCotizaciones();

        return cotizaciones.stream().map(cotizacion -> {
            try {
                // 1. Obtener datos de persona (manejar posible null)
                PersonaDTO persona = Optional.ofNullable(cotizacion.getiPersonaClave())
                        .map(personaService::obtenerPersona)
                        .orElse(new PersonaDTO());

                // 2. Obtener datos del auto (manejar posible null)
                AutoDTO auto = Optional.ofNullable(cotizacion.getiAutoClave())
                        .map(autoService::obtenerAuto)
                        .orElse(new AutoDTO());

                // 3. Obtener y asignar nombres completos del auto con manejo de null
                if (auto.getiAutoMarcaClave() != null) {
                    AutoMarcaDTO marca = Optional.ofNullable(autoMarcaService.obtenerAutoMarca(auto.getiAutoMarcaClave()))
                            .orElse(new AutoMarcaDTO());
                    auto.setvNombreMarca(marca.getvNombre() != null ? marca.getvNombre() : "");
                }

                if (auto.getiAutoModeloClave() != null) {
                    AutoModeloDTO modelo = Optional.ofNullable(autoModeloService.obtenerAuto(auto.getiAutoModeloClave()))
                            .orElse(new AutoModeloDTO());
                    auto.setvNombreModelo(modelo.getvNombre() != null ? modelo.getvNombre() : "");
                }

                if (auto.getiAutoDescripcionClave() != null) {
                    AutoDescripcionDTO descripcion = Optional.ofNullable(autoDescripcionService.obtenerAuto(auto.getiAutoDescripcionClave()))
                            .orElse(new AutoDescripcionDTO());
                    auto.setvNombreDescripcion(descripcion.getvNombre() != null ? descripcion.getvNombre() : "");
                }

                // 4. Convertir cotización a DTO con nombres de relaciones
                CotizacionDTO cotizacionDTO = convertToDTO(cotizacion);

                // Obtener y asignar nombres de las entidades relacionadas con manejo de null
                UsoDTO usoDTO = Optional.ofNullable(usoService.obtenerUso(cotizacion.getiUsoClave()))
                        .orElse(new UsoDTO());
                CategoriaVehiculoDTO categoriaVehiculoDTO = Optional.ofNullable(
                                categoriaVehiculoService.obtenerCategoriaVehiculo(cotizacion.getiCategoriaVehiculoClave()))
                        .orElse(new CategoriaVehiculoDTO());
                TipoSeguroDTO tipoSeguroDTO = Optional.ofNullable(
                                tipoSeguroService.obtenerTipoSeguro(cotizacion.getiTipoSeguroClave()))
                        .orElse(new TipoSeguroDTO());
                TipoAutoDTO tipoAutoDTO = Optional.ofNullable(
                                tipoAutoService.obtenerTipoAuto(cotizacion.getiTipoAutoClave()))
                        .orElse(new TipoAutoDTO());

                cotizacionDTO.setvNombreUso(usoDTO.getvNombre() != null ? usoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreCategoriaVehiculo(
                        categoriaVehiculoDTO.getvNombre() != null ? categoriaVehiculoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoSeguro(
                        tipoSeguroDTO.getvNombre() != null ? tipoSeguroDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoAUto(
                        tipoAutoDTO.getvNombre() != null ? tipoAutoDTO.getvNombre() : "");

                // 5. Crear y retornar respuesta completa
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setPersona(persona);
                responseDTO.setAuto(auto);
                responseDTO.setCotizacion(cotizacionDTO);

                return responseDTO;
            } catch (Exception e) {
                // Loggear el error si es necesario
                System.err.println("Error procesando cotización ID: " + cotizacion.getiCotizacionId() + ": " + e.getMessage());

                // Devolver una respuesta parcial con los datos que sí se pudieron obtener
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setCotizacion(convertToDTO(cotizacion));
                return responseDTO;
            }
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void eliminarListaCotizacion(Set<BigDecimal> cotizacionesId) {
        Optional.ofNullable(cotizacionesId)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(Objects::nonNull) // Filtra IDs nulos (opcional)
                .forEach(this::eliminarCotizacion); // Elimina cada ID

    }


    @Override
    public List<CotizacionCompletaResponseDTO> listarCotizacionesCompletasPaginadas(int offset, int limit) {
        List<Cotizacion> cotizaciones = cotizacionDao.listarCotizacionesPaginadas(offset, limit);

        return cotizaciones.stream().map(cotizacion -> {
            try {
                // 1. Obtener datos de persona (manejar posible null)
                PersonaDTO persona = Optional.ofNullable(cotizacion.getiPersonaClave())
                        .map(personaService::obtenerPersona)
                        .orElse(new PersonaDTO()); // O devolver null si prefieres

                // 2. Obtener datos del auto (manejar posible null)
                AutoDTO auto = Optional.ofNullable(cotizacion.getiAutoClave())
                        .map(autoService::obtenerAuto)
                        .orElse(new AutoDTO());

                // 3. Obtener y asignar nombres completos del auto con manejo de null
                if (auto.getiAutoMarcaClave() != null) {
                    AutoMarcaDTO marca = Optional.ofNullable(autoMarcaService.obtenerAutoMarca(auto.getiAutoMarcaClave()))
                            .orElse(new AutoMarcaDTO());
                    auto.setvNombreMarca(marca.getvNombre() != null ? marca.getvNombre() : "");
                }

                if (auto.getiAutoModeloClave() != null) {
                    AutoModeloDTO modelo = Optional.ofNullable(autoModeloService.obtenerAuto(auto.getiAutoModeloClave()))
                            .orElse(new AutoModeloDTO());
                    auto.setvNombreModelo(modelo.getvNombre() != null ? modelo.getvNombre() : "");
                }

                if (auto.getiAutoDescripcionClave() != null) {
                    AutoDescripcionDTO descripcion = Optional.ofNullable(autoDescripcionService.obtenerAuto(auto.getiAutoDescripcionClave()))
                            .orElse(new AutoDescripcionDTO());
                    auto.setvNombreDescripcion(descripcion.getvNombre() != null ? descripcion.getvNombre() : "");
                }

                // 4. Convertir cotización a DTO con nombres de relaciones
                CotizacionDTO cotizacionDTO = convertToDTO(cotizacion);

                // Obtener y asignar nombres de las entidades relacionadas con manejo de null
                UsoDTO usoDTO = Optional.ofNullable(usoService.obtenerUso(cotizacion.getiUsoClave()))
                        .orElse(new UsoDTO());
                CategoriaVehiculoDTO categoriaVehiculoDTO = Optional.ofNullable(
                                categoriaVehiculoService.obtenerCategoriaVehiculo(cotizacion.getiCategoriaVehiculoClave()))
                        .orElse(new CategoriaVehiculoDTO());
                TipoSeguroDTO tipoSeguroDTO = Optional.ofNullable(
                                tipoSeguroService.obtenerTipoSeguro(cotizacion.getiTipoSeguroClave()))
                        .orElse(new TipoSeguroDTO());
                TipoAutoDTO tipoAutoDTO = Optional.ofNullable(
                                tipoAutoService.obtenerTipoAuto(cotizacion.getiTipoAutoClave()))
                        .orElse(new TipoAutoDTO());

                cotizacionDTO.setvNombreUso(usoDTO.getvNombre() != null ? usoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreCategoriaVehiculo(
                        categoriaVehiculoDTO.getvNombre() != null ? categoriaVehiculoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoSeguro(
                        tipoSeguroDTO.getvNombre() != null ? tipoSeguroDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoAUto(
                        tipoAutoDTO.getvNombre() != null ? tipoAutoDTO.getvNombre() : "");

                // 5. Crear y retornar respuesta completa
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setPersona(persona);
                responseDTO.setAuto(auto);
                responseDTO.setCotizacion(cotizacionDTO);

                return responseDTO;
            } catch (Exception e) {
                // Loggear el error si es necesario
                System.err.println("Error procesando cotización ID: " + cotizacion.getiCotizacionId() + ": " + e.getMessage());

                // Devolver una respuesta parcial con los datos que sí se pudieron obtener
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setCotizacion(convertToDTO(cotizacion));
                return responseDTO;
            }
        }).collect(Collectors.toList());
    }



    @Override
    public List<CotizacionCompletaResponseDTO> listarCotizacionesCompletas() {
        // Obtener todas las cotizaciones sin paginación
        List<Cotizacion> cotizaciones = cotizacionDao.listarCotizacionesSinPaginado();

        return cotizaciones.stream().map(cotizacion -> {
            try {
                // 1. Obtener datos de persona (manejar posible null)
                PersonaDTO persona = Optional.ofNullable(cotizacion.getiPersonaClave())
                        .map(personaService::obtenerPersona)
                        .orElse(new PersonaDTO());

                // 2. Obtener datos del auto (manejar posible null)
                AutoDTO auto = Optional.ofNullable(cotizacion.getiAutoClave())
                        .map(autoService::obtenerAuto)
                        .orElse(new AutoDTO());

                // 3. Obtener y asignar nombres completos del auto con manejo de null
                if (auto.getiAutoMarcaClave() != null) {
                    AutoMarcaDTO marca = Optional.ofNullable(autoMarcaService.obtenerAutoMarca(auto.getiAutoMarcaClave()))
                            .orElse(new AutoMarcaDTO());
                    auto.setvNombreMarca(marca.getvNombre() != null ? marca.getvNombre() : "");
                }

                if (auto.getiAutoModeloClave() != null) {
                    AutoModeloDTO modelo = Optional.ofNullable(autoModeloService.obtenerAuto(auto.getiAutoModeloClave()))
                            .orElse(new AutoModeloDTO());
                    auto.setvNombreModelo(modelo.getvNombre() != null ? modelo.getvNombre() : "");
                }

                if (auto.getiAutoDescripcionClave() != null) {
                    AutoDescripcionDTO descripcion = Optional.ofNullable(autoDescripcionService.obtenerAuto(auto.getiAutoDescripcionClave()))
                            .orElse(new AutoDescripcionDTO());
                    auto.setvNombreDescripcion(descripcion.getvNombre() != null ? descripcion.getvNombre() : "");
                }

                // 4. Convertir cotización a DTO con nombres de relaciones
                CotizacionDTO cotizacionDTO = convertToDTO(cotizacion);

                // Obtener y asignar nombres de las entidades relacionadas con manejo de null
                UsoDTO usoDTO = Optional.ofNullable(usoService.obtenerUso(cotizacion.getiUsoClave()))
                        .orElse(new UsoDTO());
                CategoriaVehiculoDTO categoriaVehiculoDTO = Optional.ofNullable(
                                categoriaVehiculoService.obtenerCategoriaVehiculo(cotizacion.getiCategoriaVehiculoClave()))
                        .orElse(new CategoriaVehiculoDTO());
                TipoSeguroDTO tipoSeguroDTO = Optional.ofNullable(
                                tipoSeguroService.obtenerTipoSeguro(cotizacion.getiTipoSeguroClave()))
                        .orElse(new TipoSeguroDTO());
                TipoAutoDTO tipoAutoDTO = Optional.ofNullable(
                                tipoAutoService.obtenerTipoAuto(cotizacion.getiTipoAutoClave()))
                        .orElse(new TipoAutoDTO());

                cotizacionDTO.setvNombreUso(usoDTO.getvNombre() != null ? usoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreCategoriaVehiculo(
                        categoriaVehiculoDTO.getvNombre() != null ? categoriaVehiculoDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoSeguro(
                        tipoSeguroDTO.getvNombre() != null ? tipoSeguroDTO.getvNombre() : "");
                cotizacionDTO.setvNombreTipoAUto(
                        tipoAutoDTO.getvNombre() != null ? tipoAutoDTO.getvNombre() : "");

                // 5. Crear y retornar respuesta completa
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setPersona(persona);
                responseDTO.setAuto(auto);
                responseDTO.setCotizacion(cotizacionDTO);

                return responseDTO;
            } catch (Exception e) {
                // Loggear el error si es necesario
                System.err.println("Error procesando cotización ID: " + cotizacion.getiCotizacionId() + ": " + e.getMessage());

                // Devolver una respuesta parcial con los datos que sí se pudieron obtener
                CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();
                responseDTO.setCotizacion(convertToDTO(cotizacion));
                return responseDTO;
            }
        }).collect(Collectors.toList());
    }
    @Override
    public int contarTotalCotizaciones() {
        return cotizacionDao.contarTotalCotizaciones();
    }
}