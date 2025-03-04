package com.qualitas.portal.fraudes.account.domain.model;

import java.util.Date;

public class AutoMarca {
    private java.math.BigDecimal iAutoMarcaId;
    private String vNombre;
    private Date dFechaCreacion;
    private java.math.BigDecimal iUsuarioCreacion;

    // Getters y setters
    public java.math.BigDecimal getiAutoMarcaId() {
        return iAutoMarcaId;
    }

    public void setiAutoMarcaId(java.math.BigDecimal iAutoMarcaId) {
        this.iAutoMarcaId = iAutoMarcaId;
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

    public java.math.BigDecimal getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(java.math.BigDecimal iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }
}
