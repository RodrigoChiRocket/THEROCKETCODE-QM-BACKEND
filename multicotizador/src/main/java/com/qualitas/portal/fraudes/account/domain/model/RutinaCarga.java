package com.qualitas.portal.fraudes.account.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class RutinaCarga {
    private BigDecimal iRutinaCargaId;
    private String vPortal;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dFechaActualizacion;
    private Integer iDatosObtenidos;
    private LocalDateTime dProgramacion;
    private String vEstatus;
    private Integer bHabilitado;


    private LocalDateTime dInicioEjecucion;
    private LocalDateTime dFinEjecucion;

    private Long lTiempoEjecucion; // en milisegundos

    public RutinaCarga() {
    }


    public LocalDateTime getdInicioEjecucion() {
        return dInicioEjecucion;
    }

    public void setdInicioEjecucion(LocalDateTime dInicioEjecucion) {
        this.dInicioEjecucion = dInicioEjecucion;
    }

    public LocalDateTime getdFinEjecucion() {
        return dFinEjecucion;
    }

    public void setdFinEjecucion(LocalDateTime dFinEjecucion) {
        this.dFinEjecucion = dFinEjecucion;
    }

    public Long getlTiempoEjecucion() {
        return lTiempoEjecucion;
    }

    public void setlTiempoEjecucion(Long lTiempoEjecucion) {
        this.lTiempoEjecucion = lTiempoEjecucion;
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

    public LocalDateTime getdFechaActualizacion() {
        return dFechaActualizacion;
    }

    public void setdFechaActualizacion(LocalDateTime dFechaActualizacion) {
        this.dFechaActualizacion = dFechaActualizacion;
    }

    public Integer getiDatosObtenidos() {
        return iDatosObtenidos;
    }

    public void setiDatosObtenidos(Integer iDatosObtenidos) {
        this.iDatosObtenidos = iDatosObtenidos;
    }

    public LocalDateTime getdProgramacion() {
        return dProgramacion;
    }

    public void setdProgramacion(LocalDateTime dProgramacion) {
        this.dProgramacion = dProgramacion;
    }

    public String getvEstatus() {
        return vEstatus;
    }

    public void setvEstatus(String vEstatus) {
        this.vEstatus = vEstatus;
    }

    public Integer getbHabilitado() {
        return bHabilitado;
    }

    public void setbHabilitado(Integer bHabilitado) {
        this.bHabilitado = bHabilitado;
    }
}