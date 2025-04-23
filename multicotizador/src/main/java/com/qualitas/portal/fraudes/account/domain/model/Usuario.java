package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;

public class Usuario {
    private BigDecimal iIdUsuario;
    private String vUsuario;
    private String vEmail;
    private String vPasswordHash;
    private Integer iActivo;
    private BigDecimal iIdRol;

    // Constructores
    public Usuario() {
    }

    public Usuario(BigDecimal iIdUsuario, String vUsuario, String vEmail, String vPasswordHash, Integer iActivo, BigDecimal iIdRol) {
        this.iIdUsuario = iIdUsuario;
        this.vUsuario = vUsuario;
        this.vEmail = vEmail;
        this.vPasswordHash = vPasswordHash;
        this.iActivo = iActivo;
        this.iIdRol = iIdRol;
    }

    // Getters y Setters
    public BigDecimal getiIdUsuario() {
        return iIdUsuario;
    }

    public void setiIdUsuario(BigDecimal iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }

    public String getvUsuario() {
        return vUsuario;
    }

    public void setvUsuario(String vUsuario) {
        this.vUsuario = vUsuario;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvPasswordHash() {
        return vPasswordHash;
    }

    public void setvPasswordHash(String vPasswordHash) {
        this.vPasswordHash = vPasswordHash;
    }

    public Integer getiActivo() {
        return iActivo;
    }

    public void setiActivo(Integer iActivo) {
        this.iActivo = iActivo;
    }

    public BigDecimal getiIdRol() {
        return iIdRol;
    }

    public void setiIdRol(BigDecimal iIdRol) {
        this.iIdRol = iIdRol;
    }
}