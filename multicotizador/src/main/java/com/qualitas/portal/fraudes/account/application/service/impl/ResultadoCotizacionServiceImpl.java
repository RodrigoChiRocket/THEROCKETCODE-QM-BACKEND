package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoCotizacionDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.ResultadoCotizacionConvertDTO;
import com.qualitas.portal.fraudes.account.application.service.ResultadoCotizacionService;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultadoCotizacionServiceImpl implements ResultadoCotizacionService {

    @Autowired
    private ResultadoCotizacionDao resultadoCotizacionDao;

    @Autowired
    private ResultadoCotizacionConvertDTO resultadoCotizacionConvertDTO;

    @Override
    public ResultadoCotizacionDTO crearResultadoCotizacion(ResultadoCotizacionDTO dto) {
        ResultadoCotizacion resultado = resultadoCotizacionConvertDTO.dtoToEntity(dto);
        resultadoCotizacionDao.crearResultadoCotizacion(resultado);
        return resultadoCotizacionConvertDTO.entityToDto(resultado);
    }

    @Override
    public ResultadoCotizacionDTO obtenerResultadoCotizacion(BigDecimal id) {
        ResultadoCotizacion resultado = resultadoCotizacionDao.obtenerResultadoCotizacion(id);
        return resultadoCotizacionConvertDTO.entityToDto(resultado);
    }

    @Override
    public List<ResultadoCotizacionDTO> listarResultadosCotizacion() {
        return resultadoCotizacionDao.listarResultadosCotizacion().stream()
                .map(resultadoCotizacionConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResultadoCotizacionDTO actualizarResultadoCotizacion(BigDecimal id, ResultadoCotizacionDTO dto) {
        ResultadoCotizacion resultado = resultadoCotizacionConvertDTO.dtoToEntity(dto);
        resultado.setiResultadoCotizacionId(id);
        resultadoCotizacionDao.actualizarResultadoCotizacion(resultado);
        return resultadoCotizacionConvertDTO.entityToDto(resultado);
    }

    @Override
    public void eliminarResultadoCotizacion(BigDecimal id) {
        resultadoCotizacionDao.eliminarResultadoCotizacion(id);
    }



    @Override
    public List<ResultadoCotizacionDTO> obtenerResultadoPorCotizacionClave(BigDecimal cotizacionClave) {
        // Obtener la lista de entidades desde el DAO
        List<ResultadoCotizacion> resultados = resultadoCotizacionDao.obtenerResultadoPorCotizacionClave(cotizacionClave);

        // Convertir cada entidad a DTO usando el método entityToDto
        return resultados.stream()
                .map(resultado -> resultadoCotizacionConvertDTO.entityToDto(resultado)) // Usar lambda para convertir cada entidad
                .collect(Collectors.toList()); // Recolectar los resultados en una lista
    }


    @Override
    public List<ResultadoCotizacionDTO> buscarPorNombreSeguroYCotizacionClave(String nombreSeguro, BigDecimal cotizacionClave) {

        List<ResultadoCotizacion> resultados = resultadoCotizacionDao.buscarPorNombreSeguroYCotizacionClave(nombreSeguro, cotizacionClave);

        return resultados.stream()
                .map(resultado -> resultadoCotizacionConvertDTO.entityToDto(resultado))
                .collect(Collectors.toList());
    }
    @Override
    public List<String> obtenerNombresSegurosUnicos() {
        return resultadoCotizacionDao.obtenerNombresSegurosUnicos();
    }

    @Override
    public boolean verificarEstadoCotizacion(BigDecimal cotizacionClave) {
        return resultadoCotizacionDao.verificarEstadoCotizacion(cotizacionClave);
    }


    @Override
    public List<ResultadoCotizacionDTO> filtrarResultadosCotizacion(BigDecimal cotizacionClave, String nombreSeguro, String nombreCobertura) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("cotizacionClave", cotizacionClave);
        parametros.put("vNombreSeguro", nombreSeguro);
        parametros.put("vNombreCobertura", nombreCobertura);

        List<ResultadoCotizacion> resultados = resultadoCotizacionDao.filtrarResultadosCotizacion(parametros);

        return resultados.stream()
                .map(resultadoCotizacionConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }

}