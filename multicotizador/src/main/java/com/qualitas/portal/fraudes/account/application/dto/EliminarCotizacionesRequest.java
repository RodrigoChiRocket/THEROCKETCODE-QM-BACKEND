package com.qualitas.portal.fraudes.account.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


public  class EliminarCotizacionesRequest {
    private List<BigDecimal> cotizacionesId;

    public List<BigDecimal> getCotizacionesId() {
        return cotizacionesId;
    }

    public void setCotizacionesId(List<BigDecimal> cotizacionesId) {
        this.cotizacionesId = cotizacionesId;
    }
}