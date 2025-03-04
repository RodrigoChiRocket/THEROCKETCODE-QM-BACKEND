package com.qualitas.portal.fraudes.account.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AutoDescripcionDTO {
    private BigDecimal iCatalogoAutoDescripcionId;  // ID de la descripción del modelo
    private BigDecimal iAutoModeloClave;                   // ID del modelo (relación con T_CATALOGO_AUTOS_MODELO)
    private String vNombre;                    // Descripción del modelo de auto
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;

    // Constructor sin parámetros
    public AutoDescripcionDTO() {}

    // Constructor con parámetros
    public AutoDescripcionDTO(BigDecimal iCatalogoAutoDescripcionId, BigDecimal iAutoModeloClave, String vNombre, Date dFechaCreacion, BigDecimal iUsuarioCreacion) {
        this.iCatalogoAutoDescripcionId = iCatalogoAutoDescripcionId;
        this.iAutoModeloClave = iAutoModeloClave;
        this.vNombre = vNombre;
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

    public BigDecimal getiAutoModeloClave() {
        return iAutoModeloClave;
    }

    public void setiAutoModeloClave(BigDecimal iAutoModeloClave) {
        this.iAutoModeloClave = iAutoModeloClave;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
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
