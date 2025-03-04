package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Uso {
    private BigDecimal iUsoId;       // ID del uso
    private String vNombre;         // Nombre del uso
    private Date dFechaCreacion;    // Fecha de creación

    // Getters y Setters
    public BigDecimal getiUsoId() {
        return iUsoId;
    }

    public void setiUsoId(BigDecimal iUsoId) {
        this.iUsoId = iUsoId;
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
}