package com.qualitas.portal.fraudes.account.application.service;

import org.springframework.stereotype.Service;
import com.qualitas.portal.fraudes.account.domain.dto.ResultadoCotizacionDTO;

import java.util.Objects;

@Service
public class CotizacionValidatorService {
    public boolean sonCompletamenteIguales(ResultadoCotizacionDTO nuevo, ResultadoCotizacionDTO existente) {
        if (nuevo == null || existente == null) {
            return false;
        }

        // Comparar todos los campos uno por uno
        return Objects.equals(nuevo.getiCotizacionClave(), existente.getiCotizacionClave())
                && Objects.equals(nuevo.getvNombreSeguro(), existente.getvNombreSeguro())
                && Objects.equals(nuevo.getvNombreCobertura(), existente.getvNombreCobertura())
                && Objects.equals(nuevo.getdPrecioTotal(), existente.getdPrecioTotal())
                && Objects.equals(nuevo.getvPlazoCobertura(), existente.getvPlazoCobertura())
                && Objects.equals(nuevo.getdPrimerPago(), existente.getdPrimerPago())
                && Objects.equals(nuevo.getdPagosResta(), existente.getdPagosResta())
                && Objects.equals(nuevo.getiVigencia(), existente.getiVigencia())
                && Objects.equals(nuevo.getdDanosTerceros(), existente.getdDanosTerceros())
                && Objects.equals(nuevo.getiRoboTotal(), existente.getiRoboTotal())
                && Objects.equals(nuevo.getiRoboParcial(), existente.getiRoboParcial())
                && Objects.equals(nuevo.getdGastosMedicos(), existente.getdGastosMedicos())
                && Objects.equals(nuevo.getiDanosLlanta(), existente.getiDanosLlanta())
                && Objects.equals(nuevo.getiDanoCristal(), existente.getiDanoCristal())
                && Objects.equals(nuevo.getiReposicionLlave(), existente.getiReposicionLlave())
                && Objects.equals(nuevo.isbPerdidaTotal(), existente.isbPerdidaTotal())
                && Objects.equals(nuevo.getdFallecimiento(), existente.getdFallecimiento())
                && Objects.equals(nuevo.isbDefensaLegal(), existente.isbDefensaLegal())
                && Objects.equals(nuevo.isbAsistencialVialCarretera(), existente.isbAsistencialVialCarretera())
                && Objects.equals(nuevo.getiDanoVehiculo(), existente.getiDanoVehiculo());
    }

    public boolean tienenMismaClave(ResultadoCotizacionDTO nuevo, ResultadoCotizacionDTO existente) {
        if (nuevo == null || existente == null) {
            return false;
        }

        return Objects.equals(nuevo.getiCotizacionClave(), existente.getiCotizacionClave())
                && Objects.equals(nuevo.getvNombreSeguro(), existente.getvNombreSeguro())
                && Objects.equals(nuevo.getvNombreCobertura(), existente.getvNombreCobertura());
    }
}