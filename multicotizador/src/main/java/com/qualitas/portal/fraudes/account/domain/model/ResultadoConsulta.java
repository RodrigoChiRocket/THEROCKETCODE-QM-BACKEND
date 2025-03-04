package com.qualitas.portal.fraudes.account.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ResultadoConsulta {
    private BigDecimal iResultCargaId;
    private String vNombre;
    private String vSexo; // Puede ser 'Hombre', 'Mujer' o 'Prefiero no especificar'
    private Integer iCodigoPostal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dFechaNacimiento;
    private BigDecimal iAutoId; // Relación con T_CATALOGO_AUTOS
    private BigDecimal iModeloId; // Relación con T_CATALOGO_AUTOS_MODELO
    private BigDecimal iAutoDescripcionId; // Relación con T_CATALO_AUTOS_DESCRIPCION
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dFechaCreacion;
    private BigDecimal iUsuarioCreacion;

    // Constructor vacío
    public ResultadoConsulta() {
    }

    // Constructor con parámetros
    public ResultadoConsulta(BigDecimal iResultCargaId, String vNombre, String vSexo, Integer iCodigoPostal, Date dFechaNacimiento,
                             BigDecimal iAutoId, BigDecimal iModeloId, BigDecimal iAutoDescripcionId,
                             Date dFechaCreacion, BigDecimal iUsuarioCreacion) {
        this.iResultCargaId = iResultCargaId;
        this.vNombre = vNombre;
        this.vSexo = vSexo;
        this.iCodigoPostal = iCodigoPostal;
        this.dFechaNacimiento = dFechaNacimiento;
        this.iAutoId = iAutoId;
        this.iModeloId = iModeloId;
        this.iAutoDescripcionId = iAutoDescripcionId;
        this.dFechaCreacion = dFechaCreacion;
        this.iUsuarioCreacion = iUsuarioCreacion;
    }

    // Getters y setters
    public BigDecimal getiResultCargaId() {
        return iResultCargaId;
    }

    public void setiResultCargaId(BigDecimal iResultCargaId) {
        this.iResultCargaId = iResultCargaId;
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

    public BigDecimal getiAutoId() {
        return iAutoId;
    }

    public void setiAutoId(BigDecimal iAutoId) {
        this.iAutoId = iAutoId;
    }

    public BigDecimal getiModeloId() {
        return iModeloId;
    }

    public void setiModeloId(BigDecimal iModeloId) {
        this.iModeloId = iModeloId;
    }

    public BigDecimal getiAutoDescripcionId() {
        return iAutoDescripcionId;
    }

    public void setiAutoDescripcionId(BigDecimal iAutoDescripcionId) {
        this.iAutoDescripcionId = iAutoDescripcionId;
    }

    public Date getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public BigDecimal getiUsuarioCreacion() {
        return iUsuarioCreacion;
    }

    public void setiUsuarioCreacion(BigDecimal iUsuarioCreacion) {
        this.iUsuarioCreacion = iUsuarioCreacion;
    }
}
