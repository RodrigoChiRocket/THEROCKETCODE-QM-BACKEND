package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class ResultadoCotizacion {
    private BigDecimal iResultadoCotizacionId;
    private BigDecimal iCotizacionClave;
    private String vNombreSeguro;
    private String vNombreCobertura;
    private double dPrecioTotal;
    private String vPlazoCobertura;
    private double dPrimerPago;
    private double dPagosResta;
    private int iVigencia;
    private double dDanosTerceros;
    private int iRoboTotal;
    private int iRoboParcial;
    private double dGastosMedicos;
    private int iDanosLlanta;
    private int iDanoCristal;
    private int iReposicionLlave;
    private boolean bPerdidaTotal;
    private double dFallecimiento;
    private boolean bDefensaLegal;
    private boolean bAsistencialVialCarretera;
    private int iDanoVehiculo;
    private Date dFechaCreacion;

    private Integer bCatalogoDato;

    public Integer getbCatalogoDato() {
        return bCatalogoDato;
    }

    public void setbCatalogoDato(Integer bCatalogoDato) {
        this.bCatalogoDato = bCatalogoDato;
    }

    private BigDecimal iRutinaCargaClave;

    public BigDecimal getiRutinaCargaClave() {
        return iRutinaCargaClave;
    }

    public void setiRutinaCargaClave(BigDecimal iRutinaCargaClave) {
        this.iRutinaCargaClave = iRutinaCargaClave;
    }

    // Getters y Setters
    public BigDecimal getiResultadoCotizacionId() {
        return iResultadoCotizacionId;
    }

    public void setiResultadoCotizacionId(BigDecimal iResultadoCotizacionId) {
        this.iResultadoCotizacionId = iResultadoCotizacionId;
    }

    public BigDecimal getiCotizacionClave() {
        return iCotizacionClave;
    }

    public void setiCotizacionClave(BigDecimal iCotizacionClave) {
        this.iCotizacionClave = iCotizacionClave;
    }

    public String getvNombreSeguro() {
        return vNombreSeguro;
    }

    public void setvNombreSeguro(String vNombreSeguro) {
        this.vNombreSeguro = vNombreSeguro;
    }

    public String getvNombreCobertura() {
        return vNombreCobertura;
    }

    public void setvNombreCobertura(String vNombreCobertura) {
        this.vNombreCobertura = vNombreCobertura;
    }

    public double getdPrecioTotal() {
        return dPrecioTotal;
    }

    public void setdPrecioTotal(double dPrecioTotal) {
        this.dPrecioTotal = dPrecioTotal;
    }

    public String getvPlazoCobertura() {
        return vPlazoCobertura;
    }

    public void setvPlazoCobertura(String vPlazoCobertura) {
        this.vPlazoCobertura = vPlazoCobertura;
    }

    public double getdPrimerPago() {
        return dPrimerPago;
    }

    public void setdPrimerPago(double dPrimerPago) {
        this.dPrimerPago = dPrimerPago;
    }

    public double getdPagosResta() {
        return dPagosResta;
    }

    public void setdPagosResta(double dPagosResta) {
        this.dPagosResta = dPagosResta;
    }

    public int getiVigencia() {
        return iVigencia;
    }

    public void setiVigencia(int iVigencia) {
        this.iVigencia = iVigencia;
    }

    public double getdDanosTerceros() {
        return dDanosTerceros;
    }

    public void setdDanosTerceros(double dDanosTerceros) {
        this.dDanosTerceros = dDanosTerceros;
    }

    public int getiRoboTotal() {
        return iRoboTotal;
    }

    public void setiRoboTotal(int iRoboTotal) {
        this.iRoboTotal = iRoboTotal;
    }

    public int getiRoboParcial() {
        return iRoboParcial;
    }

    public void setiRoboParcial(int iRoboParcial) {
        this.iRoboParcial = iRoboParcial;
    }

    public double getdGastosMedicos() {
        return dGastosMedicos;
    }

    public void setdGastosMedicos(double dGastosMedicos) {
        this.dGastosMedicos = dGastosMedicos;
    }

    public int getiDanosLlanta() {
        return iDanosLlanta;
    }

    public void setiDanosLlanta(int iDanosLlanta) {
        this.iDanosLlanta = iDanosLlanta;
    }

    public int getiDanoCristal() {
        return iDanoCristal;
    }

    public void setiDanoCristal(int iDanoCristal) {
        this.iDanoCristal = iDanoCristal;
    }

    public int getiReposicionLlave() {
        return iReposicionLlave;
    }

    public void setiReposicionLlave(int iReposicionLlave) {
        this.iReposicionLlave = iReposicionLlave;
    }

    public boolean isbPerdidaTotal() {
        return bPerdidaTotal;
    }

    public void setbPerdidaTotal(boolean bPerdidaTotal) {
        this.bPerdidaTotal = bPerdidaTotal;
    }

    public double getdFallecimiento() {
        return dFallecimiento;
    }

    public void setdFallecimiento(double dFallecimiento) {
        this.dFallecimiento = dFallecimiento;
    }

    public boolean isbDefensaLegal() {
        return bDefensaLegal;
    }

    public void setbDefensaLegal(boolean bDefensaLegal) {
        this.bDefensaLegal = bDefensaLegal;
    }

    public boolean isbAsistencialVialCarretera() {
        return bAsistencialVialCarretera;
    }

    public void setbAsistencialVialCarretera(boolean bAsistencialVialCarretera) {
        this.bAsistencialVialCarretera = bAsistencialVialCarretera;
    }

    public int getiDanoVehiculo() {
        return iDanoVehiculo;
    }

    public void setiDanoVehiculo(int iDanoVehiculo) {
        this.iDanoVehiculo = iDanoVehiculo;
    }

    public Date getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }
}