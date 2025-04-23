package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.request.LoginRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.RegisterRequestDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO loginRequest);
    AuthResponseDTO register(RegisterRequestDTO registerRequest);
}