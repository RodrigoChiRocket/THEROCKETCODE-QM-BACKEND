package com.qualitas.portal.fraudes.account.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CotizacionDTO {
    private BigDecimal iCotizacionId;
    private BigDecimal iCategoriaVehiculoClave;
    private String vNombreCategoriaVehiculo;
    private BigDecimal iTipoSeguroClave;
    private String vNombreTipoSeguro;
    private BigDecimal iUsoClave;
    private String vNombreUso;
    private BigDecimal iTipoAutoClave;
    private  String vNombreTipoAUto;
    private BigDecimal iAutoClave;
    private BigDecimal iPersonaClave;
    private Date dFechaCreacion;
    private String iUsuarioCreacion;

    public String getvNombreCategoriaVehiculo() {
        return vNombreCategoriaVehiculo;
    }

    public void setvNombreCategoriaVehiculo(String vNombreCategoriaVehiculo) {
        this.vNombreCategoriaVehiculo = vNombreCategoriaVehiculo;
    }

    public String getvNombreTipoSeguro() {
        return vNombreTipoSeguro;
    }

    public void setvNombreTipoSeguro(String vNombreTipoSeguro) {
        this.vNombreTipoSeguro = vNombreTipoSeguro;
    }

    public String getvNombreUso() {
        return vNombreUso;
    }

    public void setvNombreUso(String vNombreUso) {
        this.vNombreUso = vNombreUso;
    }

    public String getvNombreTipoAUto() {
        return vNombreTipoAUto;
    }

    public void setvNombreTipoAUto(String vNombreTipoAUto) {
        this.vNombreTipoAUto = vNombreTipoAUto;
    }

    // Getters y Setters
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