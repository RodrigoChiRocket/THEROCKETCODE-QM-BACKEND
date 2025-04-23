package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.PasswordResetTokenDao;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import com.qualitas.portal.fraudes.account.application.dto.response.PasswordResetTokenDTO;
import com.qualitas.portal.fraudes.account.application.service.PasswordResetService;
import com.qualitas.portal.fraudes.account.domain.model.PasswordResetToken;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import com.qualitas.portal.fraudes.account.util.email.EnvioCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    private static final int EXPIRATION_MINUTES = 5;

    @Autowired
    private PasswordResetTokenDao tokenDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EnvioCorreo envioCorreo;

    @Override
    @Transactional
    public PasswordResetTokenDTO generarPasswordResetToken(String email) {
        // First delete any existing tokens for this email
        tokenDao.eliminarTokensExpirados();

        Usuario usuario = usuarioDao.obtenerUsuarioPorEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con email: " + email);
        }

        // Generate token
        String token = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = now.plusMinutes(EXPIRATION_MINUTES);

        // Create and save token
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setvToken(token);
        resetToken.setvEmail(email);
        resetToken.setdFechaCreacion(Timestamp.valueOf(now));
        resetToken.setdFechaExpiracion(Timestamp.valueOf(expiration));
        resetToken.setiUsado(0);

        tokenDao.crearPasswordResetToken(resetToken);

        // Send email
        envioCorreo.enviarCorreoRestablecimiento(email, usuario.getvUsuario(), token);

        // Return DTO
        PasswordResetTokenDTO dto = new PasswordResetTokenDTO();
        dto.setToken(token);
        dto.setEmail(email);
        dto.setExpiration(Timestamp.valueOf(expiration));

        return dto;
    }

    @Override
    public boolean validarToken(String token, String email) {
        PasswordResetToken resetToken = tokenDao.obtenerTokenPorValor(token);
        if (resetToken == null) {
            return false;
        }

        if (resetToken.getiUsado() != 0) {
            return false;
        }

        if (resetToken.getdFechaExpiracion().before(new Timestamp(System.currentTimeMillis()))) {
            return false;
        }

        return resetToken.getvEmail().equals(email);
    }

    @Override
    @Transactional
    public void resetPassword(String token, String email, String newPassword) {
        if (!validarToken(token, email)) {
            throw new RuntimeException("Token inválido o expirado");
        }

        Usuario usuario = usuarioDao.obtenerUsuarioPorEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Update password
        usuario.setvPasswordHash(passwordEncoder.encode(newPassword));
        usuarioDao.actualizarContrasena(usuario);

        // Mark token as used
        tokenDao.marcarTokenComoUsado(token);
    }
}