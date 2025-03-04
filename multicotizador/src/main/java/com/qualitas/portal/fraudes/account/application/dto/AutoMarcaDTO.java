package com.qualitas.portal.fraudes.account.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AutoMarcaDTO {
    private BigDecimal iAutoMarcaId;
    private String vNombre;
    private Date dFechaCreacion;


    // Getters y setters
    public BigDecimal getiAutoMarcaId() {
        return iAutoMarcaId;
    }

    public void setiAutoMarcaId(BigDecimal iAutoMarcaId) {
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


}
