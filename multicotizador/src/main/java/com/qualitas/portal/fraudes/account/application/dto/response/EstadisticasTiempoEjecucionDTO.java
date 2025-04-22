package com.qualitas.portal.fraudes.account.application.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadisticasTiempoEjecucionDTO {

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int totalRutinas;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String promedioFormateado;  // Formato "Xh Ym"

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String maximoFormateado;    // Formato "Xh Ym"

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String minimoFormateado;    // Formato "Xh Ym"

    // Tiempos individuales formateados como "Xh Ym Zs"
    private Map<BigDecimal, String> tiemposIndividualesFormateados;

    // Tiempos originales en milisegundos
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Map<BigDecimal, Long> tiemposIndividuales;

    // Campos internos (no se serializan a JSON)
    private transient double promedioMs;
    private transient long maximoMs;
    private transient long minimoMs;

    // Constructor
    public EstadisticasTiempoEjecucionDTO() {
        this.tiemposIndividuales = new LinkedHashMap<>();
        this.tiemposIndividualesFormateados = new LinkedHashMap<>();
    }

    // Getters y Setters
    public int getTotalRutinas() {
        return totalRutinas;
    }

    public void setTotalRutinas(int totalRutinas) {
        this.totalRutinas = totalRutinas;
    }

    public String getPromedioFormateado() {
        return promedioFormateado;
    }

    public void setPromedioFormateado(String promedioFormateado) {
        this.promedioFormateado = promedioFormateado;
    }

    public String getMaximoFormateado() {
        return maximoFormateado;
    }

    public void setMaximoFormateado(String maximoFormateado) {
        this.maximoFormateado = maximoFormateado;
    }

    public String getMinimoFormateado() {
        return minimoFormateado;
    }

    public void setMinimoFormateado(String minimoFormateado) {
        this.minimoFormateado = minimoFormateado;
    }

    public Map<BigDecimal, Long> getTiemposIndividuales() {
        return tiemposIndividuales;
    }

    public void setTiemposIndividuales(Map<BigDecimal, Long> tiemposIndividuales) {
        this.tiemposIndividuales = tiemposIndividuales;
    }

    public Map<BigDecimal, String> getTiemposIndividualesFormateados() {
        return tiemposIndividualesFormateados;
    }

    public void setTiemposIndividualesFormateados(Map<BigDecimal, String> tiemposIndividualesFormateados) {
        this.tiemposIndividualesFormateados = tiemposIndividualesFormateados;
    }

    public double getPromedioMs() {
        return promedioMs;
    }

    public void setPromedioMs(double promedioMs) {
        this.promedioMs = promedioMs;
    }

    public long getMaximoMs() {
        return maximoMs;
    }

    public void setMaximoMs(long maximoMs) {
        this.maximoMs = maximoMs;
    }

    public long getMinimoMs() {
        return minimoMs;
    }

    public void setMinimoMs(long minimoMs) {
        this.minimoMs = minimoMs;
    }
}