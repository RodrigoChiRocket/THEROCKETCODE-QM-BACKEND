package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class RutinaCarga {
    private BigDecimal iRutinaCargaId;
    private String vPortal;
    private Date dFechaActual;
    private String vNRODatos;
    private String vProgramacion;
    private String vEstatus;
    private String vHabilitado;

    public RutinaCarga() {
    }

    public RutinaCarga(BigDecimal iRutinaCargaId, String vPortal, Date dFechaActual, String vNRODatos, String vProgramacion, String vEstatus, String vHabilitado) {
        this.iRutinaCargaId = iRutinaCargaId;
        this.vPortal = vPortal;
        this.dFechaActual = dFechaActual;
        this.vNRODatos = vNRODatos;
        this.vProgramacion = vProgramacion;
        this.vEstatus = vEstatus;
        this.vHabilitado = vHabilitado;
    }

    public BigDecimal getiRutinaCargaId() {
        return iRutinaCargaId;
    }

    public void setiRutinaCargaId(BigDecimal iRutinaCargaId) {
        this.iRutinaCargaId = iRutinaCargaId;
    }

    public String getvPortal() {
        return vPortal;
    }

    public void setvPortal(String vPortal) {
        this.vPortal = vPortal;
    }

    public Date getdFechaActual() {
        return dFechaActual;
    }

    public void setdFechaActual(Date dFechaActual) {
        this.dFechaActual = dFechaActual;
    }

    public String getvNRODatos() {
        return vNRODatos;
    }

    public void setvNRODatos(String vNRODatos) {
        this.vNRODatos = vNRODatos;
    }

    public String getvProgramacion() {
        return vProgramacion;
    }

    public void setvProgramacion(String vProgramacion) {
        this.vProgramacion = vProgramacion;
    }

    public String getvEstatus() {
        return vEstatus;
    }

    public void setvEstatus(String vEstatus) {
        this.vEstatus = vEstatus;
    }

    public String getvHabilitado() {
        return vHabilitado;
    }

    public void setvHabilitado(String vHabilitado) {
        this.vHabilitado = vHabilitado;
    }
}
