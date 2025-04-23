package com.qualitas.portal.fraudes.account.Infrastructure.dao;
import com.qualitas.portal.fraudes.account.domain.model.PasswordResetToken;
import java.math.BigDecimal;

public interface PasswordResetTokenDao {
    void crearPasswordResetToken(PasswordResetToken token);
    PasswordResetToken obtenerTokenPorValor(String token);
    void marcarTokenComoUsado(String token);
    void eliminarTokensExpirados();
}