package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.PasswordResetTokenDao;
import com.qualitas.portal.fraudes.account.domain.model.PasswordResetToken;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("passwordResetTokenDaoImpl")
public class PasswordResetTokenDaoImpl extends SqlSessionDaoSupport implements PasswordResetTokenDao {

    @Override
    @Transactional
    public void crearPasswordResetToken(PasswordResetToken token) {
        getSqlSession().insert("crearPasswordResetToken", token);
    }

    @Override
    public PasswordResetToken obtenerTokenPorValor(String token) {
        return getSqlSession().selectOne("obtenerTokenPorValor", token);
    }

    @Override
    @Transactional
    public void marcarTokenComoUsado(String token) {
        getSqlSession().update("marcarTokenComoUsado", token);
    }

    @Override
    @Transactional
    public void eliminarTokensExpirados() {
        getSqlSession().delete("eliminarTokensExpirados");
    }
}