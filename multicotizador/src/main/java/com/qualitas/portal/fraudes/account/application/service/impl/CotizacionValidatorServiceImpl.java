package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.service.CotizacionValidatorService;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class CotizacionValidatorServiceImpl   {
    private static final int MIN_DIFFERENCES_REQUIRED = 3;

    public boolean tieneSuficientesDiferencias(ResultadoCotizacionDTO nuevo, ResultadoCotizacionDTO existente) {
        // Validación exhaustiva de nulos
        if (nuevo == null && existente == null) {
            return false;
        }
        if (nuevo == null || existente == null) {
            return true;
        }

        int diferencias = 0;

        // Comparación segura para todos los campos
        diferencias += compararCampo(nuevo.getvNombreSeguro(), existente.getvNombreSeguro());
        diferencias += compararCampo(nuevo.getvNombreCobertura(), existente.getvNombreCobertura());
        diferencias += compararCampo(nuevo.getdPrecioTotal(), existente.getdPrecioTotal());
        diferencias += compararCampo(nuevo.getvPlazoCobertura(), existente.getvPlazoCobertura());
        diferencias += compararCampo(nuevo.getdPrimerPago(), existente.getdPrimerPago());
        diferencias += compararCampo(nuevo.getdPagosResta(), existente.getdPagosResta());
        diferencias += compararCampo(nuevo.getiVigencia(), existente.getiVigencia());
        diferencias += compararCampo(nuevo.getdDanosTerceros(), existente.getdDanosTerceros());
        diferencias += compararCampo(nuevo.getiRoboTotal(), existente.getiRoboTotal());
        diferencias += compararCampo(nuevo.getiRoboParcial(), existente.getiRoboParcial());
        diferencias += compararCampo(nuevo.getdGastosMedicos(), existente.getdGastosMedicos());
        diferencias += compararCampo(nuevo.getiDanosLlanta(), existente.getiDanosLlanta());
        diferencias += compararCampo(nuevo.getiDanoCristal(), existente.getiDanoCristal());
        diferencias += compararCampo(nuevo.getiReposicionLlave(), existente.getiReposicionLlave());
        diferencias += (nuevo.isbPerdidaTotal() != existente.isbPerdidaTotal()) ? 1 : 0;
        diferencias += compararCampo(nuevo.getdFallecimiento(), existente.getdFallecimiento());
        diferencias += (nuevo.isbDefensaLegal() != existente.isbDefensaLegal()) ? 1 : 0;
        diferencias += (nuevo.isbAsistencialVialCarretera() != existente.isbAsistencialVialCarretera()) ? 1 : 0;
        diferencias += compararCampo(nuevo.getiDanoVehiculo(), existente.getiDanoVehiculo());

        return diferencias >= MIN_DIFFERENCES_REQUIRED;
    }

    private int compararCampo(Object valor1, Object valor2) {
        return Objects.equals(valor1, valor2) ? 0 : 1;
    }
}