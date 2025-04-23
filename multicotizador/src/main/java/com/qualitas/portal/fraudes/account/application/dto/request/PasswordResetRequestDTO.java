package com.qualitas.portal.fraudes.account.application.dto.request;

import java.io.Serializable;
import java.util.Objects;

public class PasswordResetRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String token;
    private String newPassword;

    // Default constructor
    public PasswordResetRequestDTO() {
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetRequestDTO that = (PasswordResetRequestDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(token, that.token) &&
                Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, token, newPassword);
    }

    // toString
    @Override
    public String toString() {
        return "PasswordResetRequestDTO{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", newPassword='[PROTECTED]'" +
                '}';
    }
}