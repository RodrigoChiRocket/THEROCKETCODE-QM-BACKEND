package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.request.LoginRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.RegisterRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.AuthResponseDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.InicioSesionRespuestaDto;
import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface AutenticacionService {

    AuthResponseDTO autenticarUsuario(LoginRequestDTO loginRequest);
    BigDecimal registrarUsuario(RegisterRequestDTO registerRequest);

    @Transactional
    void actualizarContrasenaPorEmail(String email, String nuevaContrasena);
}
