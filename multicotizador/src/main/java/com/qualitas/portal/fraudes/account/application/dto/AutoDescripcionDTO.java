package com.qualitas.portal.fraudes.account.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AutoDescripcionDTO {
    private BigDecimal iAutoDescripcionId;  // ID de la descripción del auto
    private BigDecimal iAutoModeloClave;   // Clave del modelo (relación con T_AUTOS_MODELO_MC)
    private String vNombre;                // Nombre de la descripción
    private Date dFechaCreacion;           // Fecha de creación
    private BigDecimal iUsuarioCreacion;   // ID del usuario que creó el registro

    // Getters y Setters
    public BigDecimal getiAutoDescripcionId() {
        return iAutoDescripcionId;
    }

    public void setiAutoDescripcionId(BigDecimal iAutoDescripcionId) {
        this.iAutoDescripcionId = iAutoDescripcionId;
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