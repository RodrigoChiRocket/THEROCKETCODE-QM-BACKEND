package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.ResultadoCotizacionDao;
import com.qualitas.portal.fraudes.account.application.convertDTO.ResultadoCotizacionConvertDTO;
import com.qualitas.portal.fraudes.account.application.service.CotizacionValidatorService;
import com.qualitas.portal.fraudes.account.application.service.ResultadoCotizacionService;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import com.qualitas.portal.fraudes.account.domain.model.ResultadoCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultadoCotizacionServiceImpl implements ResultadoCotizacionService {

    @Autowired
    private ResultadoCotizacionDao resultadoCotizacionDao;

    @Autowired
    private ResultadoCotizacionConvertDTO resultadoCotizacionConvertDTO;



    @Autowired
    private CotizacionValidatorService validatorService;

    @Override
    public ResultadoCotizacionDTO crearResultadoCotizacion(ResultadoCotizacionDTO dto) {
        ResultadoCotizacion resultado = resultadoCotizacionConvertDTO.dtoToEntity(dto);

        resultadoCotizacionDao.crearResultadoCotizacion(resultado);
        return resultadoCotizacionConvertDTO.entityToDto(resultado);
    }

    @Override
    public ResultadoCotizacionDTO crearResultadoCotizacionCatalogo(ResultadoCotizacionDTO dto) {
        // 1. Obtener todos los resultados existentes para esta cotización clave
        List<ResultadoCotizacion> existentes = resultadoCotizacionDao
                .obtenerResultadosPorCotizacionClaveYCatalogo(dto.getiCotizacionClave());

        // 2. Buscar si ya existe uno con mismo seguro y cobertura
        Optional<ResultadoCotizacion> existenteOpt = existentes.stream()
                .filter(r -> r.getvNombreSeguro().equals(dto.getvNombreSeguro())
                        && r.getvNombreCobertura().equals(dto.getvNombreCobertura()))
                .findFirst();

        if (existenteOpt.isPresent()) {
            ResultadoCotizacion existente = existenteOpt.get();

            // 3. Convertir el DTO a entidad para comparar
            ResultadoCotizacion nuevo = resultadoCotizacionConvertDTO.dtoToEntity(dto);

            // 4. Comparar campos relevantes (excluyendo ID, fechas y campos de control)
            if (sonIguales(existente, nuevo)) {

                return null; // Indica que ya existe uno idéntico
            } else {
                // 5. Eliminar el existente para insertar el nuevo
                resultadoCotizacionDao.eliminarResultadoCotizacion(existente.getiResultadoCotizacionId());

            }
        }

        // 6. Insertar el nuevo registro
        ResultadoCotizacion resultado = resultadoCotizacionConvertDTO.dtoToEntity(dto);
        String nombreSeguro = dto.getvNombreSeguro();
        BigDecimal rutinaClave = obtenerRutinaClavePorSeguro(nombreSeguro);
        resultado.setiRutinaCargaClave(rutinaClave);
        resultado.setbCatalogoDato(1);

        resultadoCotizacionDao.crearResultadoCotizacionCatalogo(resultado);
        return resultadoCotizacionConvertDTO.entityToDto(resultado);
    }

    private boolean sonIguales(ResultadoCotizacion existente, ResultadoCotizacion nuevo) {
        return Objects.equals(existente.getiCotizacionClave(), nuevo.getiCotizacionClave()) &&
                Objects.equals(existente.getvNombreSeguro(), nuevo.getvNombreSeguro()) &&
                Objects.equals(existente.getvNombreCobertura(), nuevo.getvNombreCobertura()) &&
                Objects.equals(existente.getdPrecioTotal(), nuevo.getdPrecioTotal()) &&
                Objects.equals(existente.getvPlazoCobertura(), nuevo.getvPlazoCobertura()) &&
                Objects.equals(existente.getdPrimerPago(), nuevo.getdPrimerPago()) &&
                Objects.equals(existente.getdPagosResta(), nuevo.getdPagosResta()) &&
                Objects.equals(existente.getiVigencia(), nuevo.getiVigencia()) &&
                Objects.equals(existente.getdDanosTerceros(), nuevo.getdDanosTerceros()) &&
                Objects.equals(existente.getiRoboTotal(), nuevo.getiRoboTotal()) &&
                Objects.equals(existente.getiRoboParcial(), nuevo.getiRoboParcial()) &&
                Objects.equals(existente.getdGastosMedicos(), nuevo.getdGastosMedicos()) &&
                Objects.equals(existente.getiDanosLlanta(), nuevo.getiDanosLlanta()) &&
                Objects.equals(existente.getiDanoCristal(), nuevo.getiDanoCristal()) &&
                Objects.equals(existente.getiReposicionLlave(), nuevo.getiReposicionLlave()) &&
                Objects.equals(existente.isbPerdidaTotal(), nuevo.isbPerdidaTotal()) &&
                Objects.equals(existente.getdFallecimiento(), nuevo.getdFallecimiento()) &&
                Objects.equals(existente.isbDefensaLegal(), nuevo.isbDefensaLegal()) &&
                Objects.equals(existente.isbAsistencialVialCarretera(), nuevo.isbAsistencialVialCarretera()) &&
                Objects.equals(existente.getiDanoVehiculo(), nuevo.getiDanoVehiculo());
    }
    private BigDecimal obtenerRutinaClavePorSeguro(String nombreSeguro) {
        if (nombreSeguro == null) {
            return null;
        }
        switch (nombreSeguro) {
            case "Chubb": return new BigDecimal(1);
            case "Mapfre": return new BigDecimal(2);
            case "GNP": return new BigDecimal(3);
            case "AXA": return new BigDecimal(4);
            case "HDI": return new BigDecimal(5);
            default: return null;
        }
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


    @Override
    public int contarRegistrosPorRutina(BigDecimal rutinaClave) {
        return resultadoCotizacionDao.contarRegistrosPorRutina(rutinaClave);
    }

    @Override
    public List<ResultadoCotizacionDTO> obtenerResultadoCotizacionPorCatalogo() {
        List<ResultadoCotizacion> resultadoCotizacions = resultadoCotizacionDao.obtenerResultadoDeCatalogo();


        return resultadoCotizacions.stream()
                .map(resultado -> resultadoCotizacionConvertDTO.entityToDto(resultado))
                .collect(Collectors.toList());
    }


    @Override
    public boolean existeCotizacionCompletadaPorRutina(BigDecimal rutinaCargaClave) {
        return resultadoCotizacionDao.existeCotizacionCompletadaPorRutina(rutinaCargaClave);
    }

    @Override
    public boolean eliminarResultadosCompletadosPorRutina(BigDecimal rutinaCargaClave) {
        // Verificamos primero si existe alguna cotización completada
        boolean existeCompletada = resultadoCotizacionDao.existeCotizacionCompletadaPorRutina(rutinaCargaClave);

        if(existeCompletada) {
            // Si existe, procedemos a eliminar
            resultadoCotizacionDao.eliminarResultadosCotizacionCompletados(rutinaCargaClave);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void limpiarResultadosCompletadosYErrores(BigDecimal rutinaCargaClave) {
        resultadoCotizacionDao.eliminarResultadosPorRutinaYEstado(rutinaCargaClave);
    }
    @Override
    public List<ResultadoCotizacion> obtenerResultadosDeCatalogoPorRutina(BigDecimal rutinaClave) {
        return resultadoCotizacionDao.obtenerResultadosPorRutinaYCatalogo(rutinaClave);
    }

    @Override
    public List<ResultadoCotizacionDTO> obtenerResultadosCatalogoPorCotizacionClave(BigDecimal cotizacionClave) {
        // Obtener resultados del DAO
        List<ResultadoCotizacion> resultados = resultadoCotizacionDao.obtenerResultadosPorCotizacionClaveYCatalogo(cotizacionClave);

        // Convertir a DTOs
        return resultados.stream()
                .map(resultadoCotizacionConvertDTO::entityToDto)
                .collect(Collectors.toList());
    }


}