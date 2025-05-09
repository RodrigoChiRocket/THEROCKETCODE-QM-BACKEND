package com.qualitas.portal.fraudes.account.Infrastructure.dao;


import com.qualitas.portal.fraudes.account.domain.model.Cotizacion;
import java.math.BigDecimal;
import java.util.List;

public interface CotizacionDao {
    Cotizacion crearCotizacion(Cotizacion cotizacion);
    Cotizacion crearCotizacionCatalogo(Cotizacion cotizacion);
    Cotizacion obtenerCotizacionPorId(BigDecimal id);
    Cotizacion actualizarCotizacion(Cotizacion cotizacion);
    void eliminarCotizacion(BigDecimal id);
    List<Cotizacion> listarTodasLasCotizaciones();

    Cotizacion actualizarCotizacionCatalogo(Cotizacion cotizacion);

    //PAGINADO:
    List<Cotizacion> listarCotizacionesPaginadas(int pagina, int tamanioPagina);

    void eliminarResultadosRelacionados(BigDecimal id);
    List<Cotizacion> listarCotizacionesSinPaginado();
    int contarTotalCotizaciones();
}