package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UsuarioDao {
    // Operaciones básicas de usuario
    Usuario obtenerUsuario(BigDecimal id);
    Usuario obtenerUsuarioPorEmail(String email);
    boolean existUsuario(String vEmail);
    BigDecimal crearUsuario(Usuario usuario);
    void actualizarContrasena(Usuario usuario);

    // Operaciones para autenticación
    Usuario validarUsuario(String username);
    String obtenerRolUsuario(long id);

    // Operaciones adicionales
    long obtenerRolID(String rol);
    List<Map<String, Object>> obtenerUsuarioPorRol(long rol);
    String obtenerNombreUsuarioPorId(long id); // Cambiado de obtenerUsuarioPorId

    // Método para obtener usuario completo por ID
    Usuario obtenerUsuarioPorId(long id); // Nuevo método para obtener el usuario completo

    // Método para verificar existencia por email (alias de existUsuario)
    default boolean existeUsuarioPorEmail(String email) {
        return existUsuario(email);
    }


    int actualizarContrasenaPorEmail(String email, String nuevaContrasena);
}