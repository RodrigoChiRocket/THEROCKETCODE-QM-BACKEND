package com.qualitas.portal.fraudes.account.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class AutoDTO {
    private BigDecimal iAutoId;
    private Integer dAno;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;
    private BigDecimal iAutoMarcaClave;  // Relación con AutoMarca DTO

    private BigDecimal iAutoDescripcionClave;
    private BigDecimal iAutoModeloClave;

    public BigDecimal getiAutoDescripcionClave() {
        return iAutoDescripcionClave;
    }

    public void setiAutoDescripcionClave(BigDecimal iAutoDescripcionClave) {
        this.iAutoDescripcionClave = iAutoDescripcionClave;
    }

    public BigDecimal getiAutoModeloClave() {
        return iAutoModeloClave;
    }

    public void setiAutoModeloClave(BigDecimal iAutoModeloClave) {
        this.iAutoModeloClave = iAutoModeloClave;
    }

    public BigDecimal getiAutoMarcaClave() {
        return iAutoMarcaClave;
    }

    public void setiAutoMarcaClave(BigDecimal iAutoMarcaClave) {
        this.iAutoMarcaClave = iAutoMarcaClave;
    }

    // Getters y setters
    public BigDecimal getiAutoId() {
        return iAutoId;
    }

    public void setiAutoId(BigDecimal iAutoId) {
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

    public BigDecimal getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(BigDecimal iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }
}
