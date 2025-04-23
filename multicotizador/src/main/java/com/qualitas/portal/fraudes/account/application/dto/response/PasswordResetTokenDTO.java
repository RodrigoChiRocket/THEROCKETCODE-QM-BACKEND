package com.qualitas.portal.fraudes.account.application.dto.response;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class PasswordResetTokenDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
    private String email;
    private Timestamp expiration;

    // Default constructor
    public PasswordResetTokenDTO() {
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetTokenDTO that = (PasswordResetTokenDTO) o;
        return Objects.equals(token, that.token) &&
                Objects.equals(email, that.email) &&
                Objects.equals(expiration, that.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, email, expiration);
    }

    // toString
    @Override
    public String toString() {
        return "PasswordResetTokenDTO{" +
                "token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}