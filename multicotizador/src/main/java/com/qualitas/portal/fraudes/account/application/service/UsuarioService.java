package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.application.dto.response.UsuarioRespuesta;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface UsuarioService {

    Usuario obtenerUsuarioPorEmail(String email);

    boolean existeUsuarioenDB(String vEmail);

    BigDecimal crearUsuario (Usuario usuario);
    String obtenerRolUsuario(long id);
    Usuario validarUsuario(String username);


}
