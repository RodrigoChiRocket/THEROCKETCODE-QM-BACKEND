package com.qualitas.portal.fraudes.account.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AutoDescripcionDTO {
    private BigDecimal iCatalogoAutoDescripcionId;  // ID de la descripción del modelo
    private BigDecimal iModeloId;                   // ID del modelo (relación con T_CATALOGO_AUTOS_MODELO)
    private String vDescripcion;                    // Descripción del modelo de auto
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;

    // Constructor sin parámetros
    public AutoDescripcionDTO() {}

    // Constructor con parámetros
    public AutoDescripcionDTO(BigDecimal iCatalogoAutoDescripcionId, BigDecimal iModeloId, String vDescripcion, Date dFechaCreacion, BigDecimal iUsuarioCreacion) {
        this.iCatalogoAutoDescripcionId = iCatalogoAutoDescripcionId;
        this.iModeloId = iModeloId;
        this.vDescripcion = vDescripcion;
        this.dFechaCreacion = dFechaCreacion;
        this.iUsuarioCreacion = iUsuarioCreacion;
    }

    // Getters y Setters
    public BigDecimal getiCatalogoAutoDescripcionId() {
        return iCatalogoAutoDescripcionId;
    }

    public void setiCatalogoAutoDescripcionId(BigDecimal iCatalogoAutoDescripcionId) {
        this.iCatalogoAutoDescripcionId = iCatalogoAutoDescripcionId;
    }

    public BigDecimal getiModeloId() {
        return iModeloId;
    }

    public void setiModeloId(BigDecimal iModeloId) {
        this.iModeloId = iModeloId;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    public Date getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public BigDecimal getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(BigDecimal iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }
}
