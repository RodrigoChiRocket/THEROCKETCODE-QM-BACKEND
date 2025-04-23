package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.response.PasswordResetTokenDTO;
import com.qualitas.portal.fraudes.account.domain.model.PasswordResetToken;

public interface PasswordResetService {
    PasswordResetTokenDTO generarPasswordResetToken(String email);
    boolean validarToken(String token, String email);
    void resetPassword(String token, String email, String newPassword);
}