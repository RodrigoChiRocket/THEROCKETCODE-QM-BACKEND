package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class CategoriaVehiculo {
    private BigDecimal lCategoriaVehiculoId;  // ID de la categoría de vehículo
    private String vNombre;                   // Nombre de la categoría
    private Date dFechaCreacion;              // Fecha de creación

    // Getters y Setters
    public BigDecimal getlCategoriaVehiculoId() {
        return lCategoriaVehiculoId;
    }

    public void setlCategoriaVehiculoId(BigDecimal lCategoriaVehiculoId) {
        this.lCategoriaVehiculoId = lCategoriaVehiculoId;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public Date getdFechaCreacion() {
        return dFechaCreacion;
    }

    public void setdFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }
}