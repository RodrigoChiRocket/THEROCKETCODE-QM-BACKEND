package com.qualitas.portal.fraudes.account.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

public class AutoModeloDTO {

    private BigDecimal iCatalogoAutoModeloId;  // ID del modelo de auto
    private BigDecimal iAutoId;                // ID del auto (relación con T_CATALOGO_AUTOS)
    private String vDescripcion;               // Descripción del modelo
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;


    public AutoModeloDTO() {
    }

    public BigDecimal getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(BigDecimal iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }

    public AutoModeloDTO(BigDecimal iCatalogoAutoModeloId, BigDecimal iAutoId, String vDescripcion, Date dFechaCreacion, BigDecimal iUsuarioCreacion) {
        this.iCatalogoAutoModeloId = iCatalogoAutoModeloId;
        this.iAutoId = iAutoId;
        this.vDescripcion = vDescripcion;
        this.dFechaCreacion = dFechaCreacion;
        this.iUsuarioCreacion = iUsuarioCreacion;
    }

    public BigDecimal getiCatalogoAutoModeloId() {
        return iCatalogoAutoModeloId;
    }

    public void setiCatalogoAutoModeloId(BigDecimal iCatalogoAutoModeloId) {
        this.iCatalogoAutoModeloId = iCatalogoAutoModeloId;
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
}
