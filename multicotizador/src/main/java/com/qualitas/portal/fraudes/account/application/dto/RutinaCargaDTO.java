package com.qualitas.portal.fraudes.account.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RutinaCargaDTO {
    private BigDecimal iRutinaCargaId;
    private String vPortal;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dFechaActualizacion;
    private Integer iDatosObtenidos;


    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime dProgramacion;
    private String vEstatus;
    private Integer bHabilitado;
    private String VStringHabiliatdo;

    public RutinaCargaDTO() {
    }

    public RutinaCargaDTO(BigDecimal iRutinaCargaId, String vPortal, LocalDateTime dFechaActualizacion,
                          Integer iDatosObtenidos, LocalDateTime dProgramacion,
                          String vEstatus, Integer bHabilitado) {
        this.iRutinaCargaId = iRutinaCargaId;
        this.vPortal = vPortal;
        this.dFechaActualizacion = dFechaActualizacion;
        this.iDatosObtenidos = iDatosObtenidos;
        this.dProgramacion = dProgramacion;
        this.vEstatus = vEstatus;
        this.bHabilitado = bHabilitado;
        this.VStringHabiliatdo = bHabilitado == 1 ? "SI" : "NO"; // Asignación automática
    }

    // Getters y Setters

    public String getVStringHabiliatdo() {
        return this.bHabilitado == 1 ? "SI" : "NO"; // Siempre devuelve el valor calculado
    }

    public void setVStringHabiliatdo(String VStringHabiliatdo) {
        // No es necesario implementar esto ya que el valor se calcula dinámicamente
        // Pero lo mantenemos por si hay alguna necesidad específica
        this.VStringHabiliatdo = VStringHabiliatdo;
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
        // Actualiza VStringHabiliatdo cuando cambia bHabilitado
        this.VStringHabiliatdo = bHabilitado == 1 ? "SI" : "NO";
    }
}