package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import com.qualitas.portal.fraudes.account.application.dto.request.LoginRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.RegisterRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.AuthResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.AutenticacionService;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDTO autenticarUsuario(LoginRequestDTO loginRequest) {
        // Solo autentica, no genera token aquí
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(loginRequest.getUsername());
        String rol = usuarioService.obtenerRolUsuario(usuario.getiIdUsuario().longValue());

        return new AuthResponseDTO(
                null, // El token se generará en el controlador
                usuario.getiIdUsuario(),
                usuario.getvUsuario(),
                rol
        );
    }

    @Override
    public BigDecimal registrarUsuario(RegisterRequestDTO registerRequest) {
        if (usuarioService.existeUsuarioenDB(registerRequest.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setvUsuario(registerRequest.getUsername());
        usuario.setvEmail(registerRequest.getEmail());
        usuario.setvPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        usuario.setiActivo(1);
        usuario.setiIdRol(registerRequest.getRoleId());

        return usuarioService.crearUsuario(usuario);
    }


    @Override
    @Transactional
    public void actualizarContrasenaPorEmail(String email, String nuevaContrasena) {
        String contrasenaEncriptada = passwordEncoder.encode(nuevaContrasena);
        int updated = usuarioDao.actualizarContrasenaPorEmail(email, contrasenaEncriptada);
        if (updated == 0) {
            throw new RuntimeException("No se pudo actualizar la contraseña para el email: " + email);
        }
    }
}