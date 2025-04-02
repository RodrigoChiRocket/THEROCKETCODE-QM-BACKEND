package com.qualitas.portal.fraudes.account.application.dto.response;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;public class PageDTO<T> {
    private List<T> contenido;
    private int paginaActual;
    private int tamanioPagina;
    private int totalElementos;
    private int totalPaginas;

    public PageDTO(List<T> contenido, int paginaActual, int tamanioPagina, int totalElementos) {
        this.contenido = contenido;
        this.paginaActual = paginaActual;
        this.tamanioPagina = tamanioPagina;
        this.totalElementos = totalElementos;
        this.totalPaginas = (int) Math.ceil((double) totalElementos / tamanioPagina);
    }

    // Getters necesarios para la serialización JSON
    public List<T> getContenido() {
        return contenido;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public int getTamanioPagina() {
        return tamanioPagina;
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }
}