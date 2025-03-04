package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Cotizacion {
    private BigDecimal iCotizacionId;                  // ID de la cotización
    private BigDecimal iCategoriaVehiculoClave;  // Relación con la categoría de vehículo
    private BigDecimal iTipoSeguroClave;                // Relación con el tipo de seguro
    private BigDecimal iUsoClave;                              // Relación con el tipo de uso
    private BigDecimal iTipoAutoClave;                    // Relación con el tipo de auto
    private BigDecimal iAutoClave;                            // Relación con el auto
    private BigDecimal iPersonaClave;                      // Relación con la persona
    private Date dFechaCreacion;                        // Fecha de creación
    private String iUsuarioCreacion;                    // Usuario de creación

    public BigDecimal getiCotizacionId() {
        return iCotizacionId;
    }

    public void setiCotizacionId(BigDecimal iCotizacionId) {
        this.iCotizacionId = iCotizacionId;
    }

    public BigDecimal getiCategoriaVehiculoClave() {
        return iCategoriaVehiculoClave;
    }

    public void setiCategoriaVehiculoClave(BigDecimal iCategoriaVehiculoClave) {
        this.iCategoriaVehiculoClave = iCategoriaVehiculoClave;
    }

    public BigDecimal getiTipoSeguroClave() {
        return iTipoSeguroClave;
    }

    public void setiTipoSeguroClave(BigDecimal iTipoSeguroClave) {
        this.iTipoSeguroClave = iTipoSeguroClave;
    }

    public BigDecimal getiUsoClave() {
        return iUsoClave;
    }

    public void setiUsoClave(BigDecimal iUsoClave) {
        this.iUsoClave = iUsoClave;
    }

    public BigDecimal getiTipoAutoClave() {
        return iTipoAutoClave;
    }

    public void setiTipoAutoClave(BigDecimal iTipoAutoClave) {
        this.iTipoAutoClave = iTipoAutoClave;
    }

    public BigDecimal getiAutoClave() {
        return iAutoClave;
    }

    public void setiAutoClave(BigDecimal iAutoClave) {
        this.iAutoClave = iAutoClave;
    }

    public BigDecimal getiPersonaClave() {
        return iPersonaClave;
    }

    public void setiPersonaClave(BigDecimal iPersonaClave) {
        this.iPersonaClave = iPersonaClave;
    }

    public Date getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public String getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(String iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }
}
