package com.qualitas.portal.fraudes.account.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Auto {
    private java.math.BigDecimal iAutoId;
    private Integer dAno;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dFechaCreacion;

    private java.math.BigDecimal iUsuarioCreacion;
    private BigDecimal iAutoMarcaClave;  // Relación con AutoMarca
    private BigDecimal iAutoModeloClave;
    private BigDecimal iAutoDescripcionClave;

    public BigDecimal getiAutoModeloClave() {
        return iAutoModeloClave;
    }

    public void setiAutoModeloClave(BigDecimal iAutoModeloClave) {
        this.iAutoModeloClave = iAutoModeloClave;
    }

    public BigDecimal getiAutoDescripcionClave() {
        return iAutoDescripcionClave;
    }

    public void setiAutoDescripcionClave(BigDecimal iAutoDescripcionClave) {
        this.iAutoDescripcionClave = iAutoDescripcionClave;
    }

    public java.math.BigDecimal getiAutoMarcaClave() {
        return iAutoMarcaClave;
    }

    public void setiAutoMarcaClave(BigDecimal iAutoMarcaClave) {
        this.iAutoMarcaClave = iAutoMarcaClave;
    }

    // Getters y setters
    public java.math.BigDecimal getiAutoId() {
        return iAutoId;
    }

    public void setiAutoId(java.math.BigDecimal iAutoId) {
        this.iAutoId = iAutoId;
    }

    public Integer getdAno() {
        return dAno;
    }

    public void setdAno(Integer dAno) {
        this.dAno = dAno;
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
