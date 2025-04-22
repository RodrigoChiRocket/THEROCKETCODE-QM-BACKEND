package com.qualitas.portal.fraudes.account.application.dto;

import java.util.List;
import java.util.Map;

public class ResultadosDashboardDTO {
    private List<String> meses;
    private List<String> aseguradoras;
    private List<Map<String, Object>> datosPorMes;

    // Getters y Setters
    public List<String> getMeses() {
        return meses;
    }

    public void setMeses(List<String> meses) {
        this.meses = meses;
    }

    public List<String> getAseguradoras() {
        return aseguradoras;
    }

    public void setAseguradoras(List<String> aseguradoras) {
        this.aseguradoras = aseguradoras;
    }

    public List<Map<String, Object>> getDatosPorMes() {
        return datosPorMes;
    }

    public void setDatosPorMes(List<Map<String, Object>> datosPorMes) {
        this.datosPorMes = datosPorMes;
    }
}
