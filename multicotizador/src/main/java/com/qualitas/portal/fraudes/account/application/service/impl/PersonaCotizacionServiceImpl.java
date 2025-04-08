package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.service.PersonaCotizacionService;
import com.qualitas.portal.fraudes.account.application.service.PersonaService;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonaCotizacionServiceImpl implements PersonaCotizacionService {

    @Autowired
    private PersonaService personaService;

    @Override
    public PersonaDTO crearPersonaDesdeCatalogo(CatalogoDatos catalogoDatos) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setvNombre(catalogoDatos.getNombreCompleto());
        personaDTO.setvSexo(obtenerSexoValidado(catalogoDatos.getSexo()));
        personaDTO.setdFechaNacimiento(convertirFecha(catalogoDatos.getFechaNacimiento()));
        personaDTO.setiCodigoPostal(catalogoDatos.getCodigoPostal());
        personaDTO.setvCorreo(catalogoDatos.getCorreo());
        personaDTO.setvNumeroTelefonico(catalogoDatos.getTelefono());
        return personaService.crearPersona(personaDTO);
    }

    private Sexo obtenerSexoValidado(String sexo) {
        return sexo != null ? Sexo.valueOf(sexo.toUpperCase()) : Sexo.FEMENINO;
    }

    private java.sql.Date convertirFecha(Date fecha) {
        return fecha != null ? new java.sql.Date(fecha.getTime()) : null;
    }
}