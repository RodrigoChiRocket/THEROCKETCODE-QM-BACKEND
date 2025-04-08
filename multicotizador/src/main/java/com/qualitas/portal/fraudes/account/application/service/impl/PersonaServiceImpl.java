package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.PersonaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.service.PersonaService;
import com.qualitas.portal.fraudes.account.domain.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    private static final Logger logger = LoggerFactory.getLogger(PersonaServiceImpl.class);

    @Autowired
    private PersonaDao personaDAO;

    @Autowired
    private PersonaConvertDTO personaConvertDTO;

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        logger.info("Datos recibidos para crear Persona: {}", personaDTO);
        Persona persona = personaConvertDTO.dtoToEntity(personaDTO);
        personaDAO.crearPersona(persona);
        logger.info("Persona guardada con éxito en la base de datos: {}", persona);
        return personaConvertDTO.entityToDto(persona);
    }

    @Override
    public PersonaDTO obtenerPersona(BigDecimal id) {
        Persona persona = personaDAO.obtenerPersona(id);
        if (persona == null) {
            throw new RuntimeException("Persona no encontrada con ID: " + id);
        }
        return personaConvertDTO.entityToDto(persona);
    }
    @Override
    public PersonaDTO actualizarPersona(BigDecimal id, PersonaDTO personaDTO) {
        try {
            logger.info("Actualizando persona con ID: {}", id);

            // 1. Verificar existencia
            Persona personaExistente = personaDAO.obtenerPersona(id);
            if (personaExistente == null) {
                throw new RuntimeException("Persona no encontrada con ID: " + id);
            }

            // 2. Convertir DTO a entidad
            Persona personaActualizada = personaConvertDTO.dtoToEntity(personaDTO);
            personaActualizada.setiPersonaId(id);

            // 3. Mantener todos los valores existentes si no se proporcionan en el DTO
            if (personaActualizada.getvNombre() == null) {
                personaActualizada.setvNombre(personaExistente.getvNombre());
            }

            if (personaActualizada.getvSexo() == null) {
                personaActualizada.setvSexo(personaExistente.getvSexo());
            }

            if (personaActualizada.getiCodigoPostal() == null) {
                personaActualizada.setiCodigoPostal(personaExistente.getiCodigoPostal());
            }

            if (personaActualizada.getdFechaNacimiento() == null) {
                personaActualizada.setdFechaNacimiento(personaExistente.getdFechaNacimiento());
            }

            if (personaActualizada.getvCorreo() == null) {
                personaActualizada.setvCorreo(personaExistente.getvCorreo());
            }

            if (personaActualizada.getvNumeroTelefonico() == null) {
                personaActualizada.setvNumeroTelefonico(personaExistente.getvNumeroTelefonico());
            }

            // 4. Actualizar en BD
            personaDAO.actualizarPersona(personaActualizada);

            return personaConvertDTO.entityToDto(personaActualizada);

        } catch (Exception e) {
            logger.error("Error al actualizar persona con ID: " + id, e);
            throw new RuntimeException("Error al actualizar persona: " + e.getMessage());
        }
    }
    @Override
    public List<PersonaDTO> listarPersonas() {
        return personaDAO.listarPersonas()
                .stream()
                .map(personaConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPersona(BigDecimal id) {
        Persona persona = personaDAO.obtenerPersona(id);
        if (persona == null) {
            throw new RuntimeException("Persona no encontrada con ID: " + id);
        }
        personaDAO.eliminarPersona(id);
    }
}
