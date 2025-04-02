

package com.qualitas.portal.fraudes.account.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CatalogoDatos {
    private String categoriaVehiculo;
    private String tipoVehiculo;
    private Integer ano;
    private String marca;
    private String modelo;
    private String descripcion;
    private String uso;
    private String nombreCompleto;
    private String sexo;
    @JsonFormat(
            pattern = "dd/MM/yyyy"
    )
    private Date fechaNacimiento;
    private String codigoPostal;

    public CatalogoDatos() {
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }




    public String getCategoriaVehiculo() {
        return this.categoriaVehiculo;
    }

    public void setCategoriaVehiculo(String categoriaVehiculo) {
        this.categoriaVehiculo = categoriaVehiculo;
    }

    public String getTipoVehiculo() {
        return this.tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUso() {
        return this.uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
