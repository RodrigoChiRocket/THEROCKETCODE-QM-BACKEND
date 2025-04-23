package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PasswordResetToken {
    private BigDecimal iIdToken;
    private String vToken;
    private String vEmail;
    private Timestamp dFechaCreacion;
    private Timestamp dFechaExpiracion;
    private int iUsado;

    // Getters and Setters
    public BigDecimal getiIdToken() {
        return iIdToken;
    }

    public void setiIdToken(BigDecimal iIdToken) {
        this.iIdToken = iIdToken;
    }

    public String getvToken() {
        return vToken;
    }

    public void setvToken(String vToken) {
        this.vToken = vToken;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public Timestamp getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Timestamp dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public Timestamp getdFechaExpiracion() {
        return dFechaExpiracion;
    }

    public void setdFechaExpiracion(Timestamp dFechaExpiracion) {
        this.dFechaExpiracion = dFechaExpiracion;
    }

    public int getiUsado() {
        return iUsado;
    }

    public void setiUsado(int iUsado) {
        this.iUsado = iUsado;
    }
}