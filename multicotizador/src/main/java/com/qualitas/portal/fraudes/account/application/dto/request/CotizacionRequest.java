package com.qualitas.portal.fraudes.account.application.dto.request;

import java.math.BigDecimal;
import java.util.Date;

public class CotizacionRequest {

    // Parámetros de Persona
    private BigDecimal iPersonaId;
    private String vNombre;
    private String vSexo;
    private Integer iCodigoPostal;
    private Date dFechaNacimiento;
    private String vCorreo;
    private String vNumeroTelefonico;

    // Parámetros de Auto
    private BigDecimal iAutoId;
    private Integer dAno;
    private Date dFechaCreacionAuto;
    private BigDecimal iUsuarioCreacionAuto;
    private BigDecimal iAutoMarcaClave;
    private BigDecimal iAutoModeloClave;
    private BigDecimal iAutoDescripcionClave;

    // Parámetros de Cotización
    private BigDecimal iCotizacionId;
    private BigDecimal iCategoriaVehiculoClave;
    private BigDecimal iTipoSeguroClave;
    private BigDecimal iUsoClave;
    private BigDecimal iTipoAutoClave;
    private BigDecimal iAutoClave;
    private BigDecimal iPersonaClave;
    private Date dFechaCreacionCotizacion;
    private String iUsuarioCreacionCotizacion;

    // Getters y Setters para Persona
    public BigDecimal getiPersonaId() {
        return iPersonaId;
    }

    public void setiPersonaId(BigDecimal iPersonaId) {
        this.iPersonaId = iPersonaId;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public String getvSexo() {
        return vSexo;
    }

    public void setvSexo(String vSexo) {
        this.vSexo = vSexo;
    }

    public Integer getiCodigoPostal() {
        return iCodigoPostal;
    }

    public void setiCodigoPostal(Integer iCodigoPostal) {
        this.iCodigoPostal = iCodigoPostal;
    }

    public Date getdFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setdFechaNacimiento(Date dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public String getvCorreo() {
        return vCorreo;
    }

    public void setvCorreo(String vCorreo) {
        this.vCorreo = vCorreo;
    }

    public String getvNumeroTelefonico() {
        return vNumeroTelefonico;
    }

    public void setvNumeroTelefonico(String vNumeroTelefonico) {
        this.vNumeroTelefonico = vNumeroTelefonico;
    }

    // Getters y Setters para Auto
    public BigDecimal getiAutoId() {
        return iAutoId;
    }

    public void setiAutoId(BigDecimal iAutoId) {
        this.iAutoId = iAutoId;
    }

    public Integer getdAno() {
        return dAno;
    }

    public void setdAno(Integer dAno) {
        this.dAno = dAno;
    }

    public Date getdFechaCreacionAuto() {
        return dFechaCreacionAuto;
    }

    public void setdFechaCreacionAuto(Date dFechaCreacionAuto) {
        this.dFechaCreacionAuto = dFechaCreacionAuto;
    }

    public BigDecimal getiUsuarioCreacionAuto() {
        return iUsuarioCreacionAuto;
    }

    public void setiUsuarioCreacionAuto(BigDecimal iUsuarioCreacionAuto) {
        this.iUsuarioCreacionAuto = iUsuarioCreacionAuto;
    }

    public BigDecimal getiAutoMarcaClave() {
        return iAutoMarcaClave;
    }

    public void setiAutoMarcaClave(BigDecimal iAutoMarcaClave) {
        this.iAutoMarcaClave = iAutoMarcaClave;
    }

    public BigDecimal getiAutoModeloClave() {
        return iAutoModeloClave;
    }

    public void setiAutoModeloClave(BigDecimal iAutoModeloClave) {
        this.iAutoModeloClave = iAutoModeloClave;
    }

    public BigDecimal getiAutoDescripcionClave() {
        return iAutoDescripcionClave;
    }

    public void setiAutoDescripcionClave(BigDecimal iAutoDescripcionClave) {
        this.iAutoDescripcionClave = iAutoDescripcionClave;
    }

    // Getters y Setters para Cotización
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

    public Date getdFechaCreacionCotizacion() {
        return dFechaCreacionCotizacion;
    }

    public void setdFechaCreacionCotizacion(Date dFechaCreacionCotizacion) {
        this.dFechaCreacionCotizacion = dFechaCreacionCotizacion;
    }

    public String getiUsuarioCreacionCotizacion() {
        return iUsuarioCreacionCotizacion;
    }

    public void setiUsuarioCreacionCotizacion(String iUsuarioCreacionCotizacion) {
        this.iUsuarioCreacionCotizacion = iUsuarioCreacionCotizacion;
    }
}