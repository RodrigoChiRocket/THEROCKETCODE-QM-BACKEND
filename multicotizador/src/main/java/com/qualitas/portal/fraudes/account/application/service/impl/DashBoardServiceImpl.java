package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoCotizacionDao;
import com.qualitas.portal.fraudes.account.application.dto.response.EstadisticasCoberturaDTO;
import com.qualitas.portal.fraudes.account.application.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private ResultadoCotizacionDao resultadoCotizacionDao;
    @Override
    public List<Map<String, Object>> obtenerConteoResultadosPorMes() {
        return resultadoCotizacionDao.obtenerConteoResultadosPorMes();
    }

    @Override
    public EstadisticasCoberturaDTO obtenerEstadisticasCoberturasMesActual() {
        return resultadoCotizacionDao.obtenerEstadisticasCoberturasMesActual();
    }
}
