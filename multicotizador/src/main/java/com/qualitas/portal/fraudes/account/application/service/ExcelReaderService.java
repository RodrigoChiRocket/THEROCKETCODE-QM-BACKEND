package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.domain.model.Vehiculo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelReaderService {

    public List<Vehiculo> procesarExcel(MultipartFile archivoExcel) throws IOException {
        if (archivoExcel == null || archivoExcel.isEmpty()) {
            throw new IllegalArgumentException("El archivo Excel no puede estar vacío");
        }

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        try (InputStream inputStream = archivoExcel.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet hoja = workbook.getSheetAt(0);

            // Validar que la hoja tenga datos
            if (hoja.getPhysicalNumberOfRows() <= 1) {
                throw new IllegalArgumentException("El archivo Excel no contiene datos");
            }

            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);
                if (fila != null) {
                    Vehiculo vehiculo = mapearFilaAVehiculo(fila);
                    if (vehiculo != null) {
                        listaVehiculos.add(vehiculo);
                    }
                }
            }
        }

        return listaVehiculos;
    }

    private Vehiculo mapearFilaAVehiculo(Row fila) {
        try {
            Vehiculo vehiculo = new Vehiculo();

            vehiculo.setCategoriaVehiculo(obtenerStringDeCelda(fila.getCell(0)));
            vehiculo.setTipoVehiculo(obtenerStringDeCelda(fila.getCell(1)));
            vehiculo.setAno(obtenerEnteroDeCelda(fila.getCell(2)));
            vehiculo.setModelo(obtenerStringDeCelda(fila.getCell(3)));
            vehiculo.setUso(obtenerStringDeCelda(fila.getCell(4)));
            vehiculo.setNombreCompleto(obtenerStringDeCelda(fila.getCell(5)));
            vehiculo.setSexo(obtenerStringDeCelda(fila.getCell(6)));
            vehiculo.setFechaNacimiento(obtenerFechaDeCelda(fila.getCell(7)));
            vehiculo.setCodigoPostal(obtenerStringDeCelda(fila.getCell(8)));

            return vehiculo;
        } catch (Exception e) {
            return null; // O maneja el error como prefieras
        }
    }

    private String obtenerStringDeCelda(Cell celda) {
        if (celda == null) return null;

        switch (celda.getCellType()) {
            case STRING:
                return celda.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) celda.getNumericCellValue());
            default:
                return null;
        }
    }

    private Integer obtenerEnteroDeCelda(Cell celda) {
        if (celda == null) return null;

        if (celda.getCellType() == CellType.NUMERIC) {
            return (int) celda.getNumericCellValue();
        } else if (celda.getCellType() == CellType.STRING) {
            try {
                return Integer.parseInt(celda.getStringCellValue().trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    private Date obtenerFechaDeCelda(Cell celda) {
        if (celda == null) return null;

        if (celda.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(celda)) {
            return celda.getDateCellValue();
        }
        return null;
    }
}