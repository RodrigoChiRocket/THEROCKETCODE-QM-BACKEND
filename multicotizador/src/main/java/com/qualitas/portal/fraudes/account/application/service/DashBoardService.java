package com.qualitas.portal.fraudes.account.application.service;

import java.util.List;
import java.util.Map;
import com.qualitas.portal.fraudes.account.application.dto.response.EstadisticasCoberturaDTO;
public interface DashBoardService {
    List<Map<String, Object>> obtenerConteoResultadosPorMes();

    EstadisticasCoberturaDTO obtenerEstadisticasCoberturasMesActual();
}
