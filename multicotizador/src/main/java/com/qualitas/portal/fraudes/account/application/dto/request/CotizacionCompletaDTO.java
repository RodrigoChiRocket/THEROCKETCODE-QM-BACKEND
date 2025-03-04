package com.qualitas.portal.fraudes.account.application.dto.request;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;

import java.math.BigDecimal;
import java.util.Date;

public class CotizacionCompletaDTO {
    private PersonaDTO persona;
    private AutoDTO auto;
    private CotizacionDTO cotizacion;

    // Getters y Setters
    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public AutoDTO getAuto() {
        return auto;
    }

    public void setAuto(AutoDTO auto) {
        this.auto = auto;
    }

    public CotizacionDTO getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionDTO cotizacion) {
        this.cotizacion = cotizacion;
    }
}