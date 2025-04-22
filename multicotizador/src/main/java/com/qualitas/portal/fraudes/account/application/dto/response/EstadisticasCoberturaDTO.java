package com.qualitas.portal.fraudes.account.application.dto.response;


public class EstadisticasCoberturaDTO {
    private int cantidadValida;
    private int cantidadError;

    // Constructores
    public EstadisticasCoberturaDTO() {
    }

    public EstadisticasCoberturaDTO(int cantidadValida, int cantidadError) {
        this.cantidadValida = cantidadValida;
        this.cantidadError = cantidadError;
    }

    // Getters y Setters
    public int getCantidadValida() {
        return cantidadValida;
    }

    public void setCantidadValida(int cantidadValida) {
        this.cantidadValida = cantidadValida;
    }

    public int getCantidadError() {
        return cantidadError;
    }

    public void setCantidadError(int cantidadError) {
        this.cantidadError = cantidadError;
    }
}