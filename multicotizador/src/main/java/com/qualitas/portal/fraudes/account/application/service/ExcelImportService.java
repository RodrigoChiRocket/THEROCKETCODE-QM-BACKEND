package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.sql.JDBCType.NUMERIC;

@Service
public class ExcelImportService {

    // Datos hardcodeados para mapeo de nombres a IDs
    private static final Map<String, BigDecimal> MARCAS = new HashMap<String, BigDecimal>() {{
        put("Nacional", BigDecimal.valueOf(1));
        put("TOYOTA", BigDecimal.valueOf(21));
        put("HONDA", BigDecimal.valueOf(22));
    }};

    private static final Map<String, BigDecimal> MODELOS = new HashMap<String, BigDecimal>() {{
        put("Honda CRV", BigDecimal.valueOf(101));
        put("COROLLA CROSS", BigDecimal.valueOf(102));
    }};

    private static final Map<String, BigDecimal> CATEGORIAS = new HashMap<String, BigDecimal>() {{
        put("SUV", BigDecimal.valueOf(1));
        put("Pickup", BigDecimal.valueOf(2));
        put("Sedan", BigDecimal.valueOf(3));
    }};

    public List<CotizacionCompletaResponseDTO> procesarExcel(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Primera hoja

        List<Map<String, String>> datos = new ArrayList<>();
        Row headerRow = sheet.getRow(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> fila = new HashMap<>();

            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                String header = headerRow.getCell(j).getStringCellValue().trim();
                Cell cell = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                switch (cell.getCellType()) {
                    case STRING:
                        fila.put(header, cell.getStringCellValue().trim());
                        break;
                    case NUMERIC:
                        fila.put(header, String.valueOf((int)cell.getNumericCellValue()));
                        break;
                    default:
                        fila.put(header, "");
                }
            }
            datos.add(fila);
        }

        workbook.close();
        return mapearADtosCompletos(datos);
    }

    private List<Map<String, String>> leerDatosCSV(InputStream inputStream) throws IOException {
        List<Map<String, String>> datos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Leer encabezados
            String linea = reader.readLine();
            if (linea == null) {
                throw new IOException("El archivo CSV está vacío");
            }

            String[] encabezados = linea.split(",");

            // Leer filas de datos
            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(",");
                Map<String, String> fila = new HashMap<>();

                for (int i = 0; i < encabezados.length && i < valores.length; i++) {
                    fila.put(encabezados[i].trim(), valores[i].trim());
                }
                datos.add(fila);
            }
        }
        return datos;
    }

    private List<CotizacionCompletaResponseDTO> mapearADtosCompletos(List<Map<String, String>> datos) {
        return datos.stream().map(fila -> {
            CotizacionCompletaResponseDTO dto = new CotizacionCompletaResponseDTO();
            dto.setPersona(mapearPersona(fila));
            dto.setAuto(mapearAuto(fila));
            dto.setCotizacion(mapearCotizacion(fila));
            return dto;
        }).collect(Collectors.toList());
    }

    private PersonaDTO mapearPersona(Map<String, String> fila) {
        PersonaDTO persona = new PersonaDTO();
        persona.setvNombre(fila.get("Nombre Completo"));


            String sexoStr = fila.containsKey("Sexo") ? fila.get("Sexo").toUpperCase() : "";
            persona.setvSexo(Sexo.valueOf(sexoStr));



        try {
            persona.setiCodigoPostal(Integer.parseInt(fila.get("Codigo postal")));
        } catch (NumberFormatException e) {
            persona.setiCodigoPostal(0);
        }

        return persona;
    }

    private AutoDTO mapearAuto(Map<String, String> fila) {
        AutoDTO auto = new AutoDTO();

        try {
            auto.setdAno(Integer.parseInt(fila.get("Año")));
        } catch (NumberFormatException e) {
            auto.setdAno(2000);
        }

        auto.setvNombreModelo(fila.get("Modelo"));
        auto.setiAutoMarcaClave(MARCAS.getOrDefault(fila.get("Tipo de vehiculo"), BigDecimal.ONE));
        auto.setiAutoModeloClave(MODELOS.getOrDefault(fila.get("Modelo"), BigDecimal.valueOf(101)));

        return auto;
    }

    private CotizacionDTO mapearCotizacion(Map<String, String> fila) {
        CotizacionDTO cotizacion = new CotizacionDTO();
        cotizacion.setiCategoriaVehiculoClave(
                CATEGORIAS.getOrDefault(fila.get("Categoria vehiculo"), BigDecimal.ONE)
        );
        return cotizacion;
    }
}