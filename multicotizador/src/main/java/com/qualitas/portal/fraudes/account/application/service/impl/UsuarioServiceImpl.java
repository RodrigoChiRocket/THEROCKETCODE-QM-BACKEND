package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.dto.response.UsuarioRespuesta;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioDao.obtenerUsuarioPorEmail(email);
    }

    @Override
    public boolean existeUsuarioenDB(String email) {
        return usuarioDao.existeUsuarioPorEmail(email);
    }

    @Override
    public String obtenerRolUsuario(long id) {
        return usuarioDao.obtenerRolUsuario(id);
    }

    @Transactional
    @Override
    public BigDecimal crearUsuario(Usuario usuario) {
        if (existeUsuarioenDB(usuario.getvEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        return usuarioDao.crearUsuario(usuario);
    }

    @Override
    public Usuario validarUsuario(String username) {
        Usuario usuario = usuarioDao.obtenerUsuarioPorEmail(username);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }


}