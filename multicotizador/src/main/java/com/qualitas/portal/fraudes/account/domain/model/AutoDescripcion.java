package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class AutoDescripcion {
    private BigDecimal iAutoDescripcionId;  // ID de la descripción del modelo
    private BigDecimal iAutoModeloClave;                   // ID del modelo (relación con T_CATALOGO_AUTOS_MODELO)
    private String vNombre;                    // Descripción del modelo de auto
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;

    public BigDecimal getiAutoModeloClave() {
        return iAutoModeloClave;
    }

    public void setiAutoModeloClave(BigDecimal iAutoModeloClave) {
        this.iAutoModeloClave = iAutoModeloClave;
    }

    // Getters y Setters
    public BigDecimal getiAutoDescripcionId() {
        return iAutoDescripcionId;
    }

    public void setiAutoDescripcionId(BigDecimal iAutoDescripcionId) {
        this.iAutoDescripcionId = iAutoDescripcionId;
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
