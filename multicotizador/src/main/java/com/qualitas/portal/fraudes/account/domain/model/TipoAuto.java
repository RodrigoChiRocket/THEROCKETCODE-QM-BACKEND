package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class TipoAuto {
    private BigDecimal lTipoAutoId;       // ID del tipo de auto
    private String vNombre;              // Nombre del tipo de auto
    private Date dFechaCreacion;         // Fecha de creación
    private String lUsuarioCreacion;     // Usuario que creó el registro

    // Getters y Setters
    public BigDecimal getlTipoAutoId() {
        return lTipoAutoId;
    }

    public void setlTipoAutoId(BigDecimal lTipoAutoId) {
        this.lTipoAutoId = lTipoAutoId;
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

    public String getlUsuarioCreacion() {
        return lUsuarioCreacion;
    }

    public void setlUsuarioCreacion(String lUsuarioCreacion) {
        this.lUsuarioCreacion = lUsuarioCreacion;
    }
}