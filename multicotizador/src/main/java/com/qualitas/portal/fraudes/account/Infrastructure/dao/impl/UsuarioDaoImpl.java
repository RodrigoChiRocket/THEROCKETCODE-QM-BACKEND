package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository("usuarioDAOImpl")
public class UsuarioDaoImpl extends SqlSessionDaoSupport implements UsuarioDao {

    @Override
    public Usuario obtenerUsuario(BigDecimal id) {
        return obtenerUsuarioPorId(id.longValue());
    }

    @Override
    public Usuario validarUsuario(String username) {
        Usuario usuario = getSqlSession().selectOne("validarUsuario", username);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado: " + username);
        }
        return usuario;
    }

    @Override
    public boolean existUsuario(String vEmail) {
        Integer count = getSqlSession().selectOne("existeUsuarioPorEmail", vEmail);
        return count != null && count > 0;
    }

    @Override
    public String obtenerRolUsuario(long id) {
        String rol = getSqlSession().selectOne("obtenerRolUsuario", id);
        if (rol == null) {
            throw new RuntimeException("No se encontró rol para el usuario con ID: " + id);
        }
        return rol;
    }

    @Override
    public long obtenerRolID(String rol) {
        Long rolId = getSqlSession().selectOne("obtenerRolID", rol);
        if (rolId == null) {
            throw new RuntimeException("Rol no encontrado: " + rol);
        }
        return rolId;
    }

    @Override
    public List<Map<String, Object>> obtenerUsuarioPorRol(long rol) {
        List<Map<String, Object>> usuarios = getSqlSession().selectList("obtenerUsuarioPorRol", rol);
        if (usuarios == null || usuarios.isEmpty()) {
            throw new RuntimeException("No se encontraron usuarios para el rol: " + rol);
        }
        return usuarios;
    }

    @Override
    public String obtenerNombreUsuarioPorId(long id) {
        String usuario = getSqlSession().selectOne("obtenerNombreUsuarioPorId", id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }

    @Override
    public Usuario obtenerUsuarioPorId(long id) {
        Usuario usuario = getSqlSession().selectOne("obtenerUsuarioPorId", id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }

    @Override
    @Transactional
    public void actualizarContrasena(Usuario usuario) {
        int updated = getSqlSession().update("actualizarContrasena", usuario);
        if (updated == 0) {
            throw new RuntimeException("No se actualizó la contraseña para el usuario: " + usuario.getiIdUsuario());
        }
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        Usuario usuario = getSqlSession().selectOne("obtenerUsuarioPorEmail", email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con email: " + email);
        }
        return usuario;
    }

    @Override
    @Transactional
    public BigDecimal crearUsuario(Usuario usuario) {
        try {
            int result = getSqlSession().insert("crearUsuario", usuario);
            if (result == 0) {
                throw new RuntimeException("No se pudo crear el usuario");
            }
            return usuario.getiIdUsuario();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear usuario: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public int actualizarContrasenaPorEmail(String email, String nuevaContrasena) {
        Usuario usuario = obtenerUsuarioPorEmail(email);
        usuario.setvPasswordHash(nuevaContrasena);
        return getSqlSession().update("actualizarContrasenaPorEmail", usuario);
    }
}