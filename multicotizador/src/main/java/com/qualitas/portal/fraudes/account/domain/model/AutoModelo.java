package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class AutoModelo {

    private BigDecimal iAutoModeloId;  // ID del modelo de auto
    private BigDecimal iAutoMarcaClave; // ID de la marca (relación con T_AUTOS_MARCA_MC)
    private String vNombre;            // Nombre del modelo
    private Date dFechaCreacion;       // Fecha de creación
    private BigDecimal iUsuarioCreacion; // ID del usuario que creó el registro

    // Getters y setters
    public BigDecimal getiAutoModeloId() {
        return iAutoModeloId;
    }

    public void setiAutoModeloId(BigDecimal iAutoModeloId) {
        this.iAutoModeloId = iAutoModeloId;
    }

    public BigDecimal getiAutoMarcaClave() {
        return iAutoMarcaClave;
    }

    public void setiAutoMarcaClave(BigDecimal iAutoMarcaClave) {
        this.iAutoMarcaClave = iAutoMarcaClave;
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