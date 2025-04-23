package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;

public class Rol {
    private BigDecimal iIdRol;
    private String vNombre;

    public Rol() {
    }

    public Rol(BigDecimal iIdRol, String vNombre) {
        this.iIdRol = iIdRol;
        this.vNombre = vNombre;
    }

    // Getters y Setters
    public BigDecimal getiIdRol() {
        return iIdRol;
    }

    public void setiIdRol(BigDecimal iIdRol) {
        this.iIdRol = iIdRol;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }
}