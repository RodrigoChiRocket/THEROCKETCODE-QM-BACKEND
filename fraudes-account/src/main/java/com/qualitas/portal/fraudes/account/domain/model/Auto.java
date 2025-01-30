package com.qualitas.portal.fraudes.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


public class Auto {
    private BigDecimal iAutoId;
    private String vDescripcion;
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;

    public Auto() {
    }

    public Auto(BigDecimal iAutoId, String vDescripcion, Date dFechaCreacion, BigDecimal iUsuarioCreacion) {
        this.iAutoId = iAutoId;
        this.vDescripcion = vDescripcion;
        this.dFechaCreacion = dFechaCreacion;
        this.iUsuarioCreacion = iUsuarioCreacion;
    }

    public BigDecimal getiAutoId() {
        return iAutoId;
    }

    public void setiAutoId(BigDecimal iAutoId) {
        this.iAutoId = iAutoId;
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
