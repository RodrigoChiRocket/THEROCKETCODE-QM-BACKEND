package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.*;
import com.qualitas.portal.fraudes.account.application.dto.AutoDTO;
import com.qualitas.portal.fraudes.account.application.dto.CotizacionDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.CotizacionCompletaDTO;
import com.qualitas.portal.fraudes.account.application.dto.response.CotizacionCompletaResponseDTO;
import com.qualitas.portal.fraudes.account.application.service.*;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import com.qualitas.portal.fraudes.account.domain.model.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.qualitas.portal.fraudes.account.domain.model.Uso;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CatalogoDatosServiceImpl implements CatalogoDatosService {


    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Autowired
    private AutoMarcaDao autoMarcaDao;

    @Autowired
    private AutoModeloDao autoModeloDao;

    @Autowired
    private PersonaService personaService;
    @Autowired
    private UsoService usoService;

    @Autowired
    private AutoDescripcionDao autoDescripcionDao;

    @Autowired
    private TipoAutoDao tipoAutoDao;

    @Autowired
    private CotizacionService cotizacionService;


    @Autowired
    private UsoDao usoDao;
    @Autowired
    private CategoriaVehiculoDao categoriaVehiculoDao;




    @Autowired
    private AutoService autoService;

    @Override
    public CotizacionCompletaResponseDTO crearCotizacionCompletaDesdeCatalogo(CatalogoDatos catalogoDatos) {
        try {



            // 1. Crear PersonaDTO
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setvNombre(catalogoDatos.getNombreCompleto());

            // Sexo con manejo de nulos
            personaDTO.setvSexo(catalogoDatos.getSexo() != null ?
                    Sexo.valueOf(catalogoDatos.getSexo().toUpperCase()) :
                    Sexo.FEMENINO);

            // Fecha de nacimiento (usando java.sql.Date)
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            personaDTO.setdFechaNacimiento(new java.sql.Date(sdf.parse("12-10-2003").getTime()));

            // Campos hardcodeados
            personaDTO.setiCodigoPostal(1234566);
            personaDTO.setvCorreo("pruebadeExcel" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com");
            personaDTO.setvNumeroTelefonico("5512345678");

            personaDTO = personaService.crearPersona(personaDTO);





            /*
            Auto
             */

            // 2. Crear AutoDTO
            AutoMarca autoMarca = autoMarcaDao.obtenerAutoMarcaPorNombre(catalogoDatos.getMarca());
            if (autoMarca == null) {
                throw new RuntimeException("Marca no encontrada");
            }

            AutoModelo autoModelo = autoModeloDao.obtenerModeloPorNombre(catalogoDatos.getModelo());
            if (autoModelo == null) {
                throw new RuntimeException("Modelo no encontrado");
            }

            AutoDescripcion autoDescripcion = autoDescripcionDao.obtenerAutoDescripcionPorNombre(catalogoDatos.getDescripcion());
            if (autoDescripcion == null) {
                throw new RuntimeException("Descripción no encontrada");
            }

            AutoDTO autoDTO = new AutoDTO();
            autoDTO.setdAno(catalogoDatos.getAno());
            autoDTO.setiAutoMarcaClave(autoMarca.getiAutoMarcaId());
            autoDTO.setiAutoModeloClave(autoModelo.getiAutoModeloId());
            autoDTO.setiAutoDescripcionClave(autoDescripcion.getiAutoDescripcionId());
            autoDTO.setiUsuarioCreacion(new BigDecimal(1));

            // Fecha de creación como java.sql.Date (importante)
            autoDTO.setdFechaCreacion(new java.sql.Date(System.currentTimeMillis())); // Usa fecha actual

            AutoDTO auto =autoService.crearAuto(autoDTO);









            /*
            uso= usoDao.obtenerUsoPorNombre(catalogoDatos.getUso());

            if (uso == null) {
                throw new RuntimeException("Uso es nulo, verificar xml");

            }

   */


            CotizacionDTO cotizacionDTO= new CotizacionDTO();

            CategoriaVehiculo categoriaVehiculo = categoriaVehiculoDao.obtenerCategoriaVehiculoPorNombre(catalogoDatos.getCategoriaVehiculo());
            TipoAuto tipoAuto = tipoAutoDao.obtenerTipoAutoPorNombre(catalogoDatos.getTipoVehiculo());
            Uso uso = usoService.obtenerUsoPorNombre(catalogoDatos.getUso());

            cotizacionDTO.setiTipoAutoClave(tipoAuto.getlTipoAutoId());
            cotizacionDTO.setiCategoriaVehiculoClave(categoriaVehiculo.getlCategoriaVehiculoId());
            cotizacionDTO.setiUsoClave(uso.getiUsoId());
            cotizacionDTO.setiAutoClave(auto.getiAutoId());
            cotizacionDTO.setiPersonaClave(personaDTO.getiPersonaId());
            cotizacionDTO.setdFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
            cotizacionDTO.setiTipoSeguroClave(new BigDecimal(1));
            cotizacionDTO.setiUsuarioCreacion("Developer");

            cotizacionDTO = cotizacionService.crearCotizacionCatalogo(cotizacionDTO);

            cotizacionDTO.setvNombreCategoriaVehiculo(categoriaVehiculo.getvNombre());
            cotizacionDTO.setvNombreTipoAUto(tipoAuto.getvNombre());
            cotizacionDTO.setvNombreTipoSeguro("Seguro Anual");
            cotizacionDTO.setvNombreUso(uso.getvNombre());

            CotizacionCompletaResponseDTO responseDTO = new CotizacionCompletaResponseDTO();

            responseDTO.setCotizacion(cotizacionDTO);
            responseDTO.setAuto(auto);
            responseDTO.setPersona(personaDTO);

            return responseDTO;


        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear fecha", e);
        }







    }
    @Override
    public List<CatalogoDatos> procesarCatalogoExcel(MultipartFile archivo) {
        List<CatalogoDatos> catalogo = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(archivo.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre las filas (empezando desde la fila 1 para omitir encabezados)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null || isEmptyRow(row)) { // Saltar filas vacías
                    continue;
                }

                CatalogoDatos dto = new CatalogoDatos();


                // Mapeo de columnas
                dto.setCategoriaVehiculo(getStringValue(row.getCell(0))); // A
                dto.setTipoVehiculo(getStringValue(row.getCell(1)));      // B
                dto.setAno(getIntValue(row.getCell(2)));                  // C
                dto.setMarca(getStringValue(row.getCell(3)));             // D
                dto.setModelo(getStringValue(row.getCell(4)));            // E
                dto.setDescripcion(getStringValue(row.getCell(5)));       // F
                dto.setUso(getStringValue(row.getCell(6)));              // G
                dto.setNombreCompleto(getStringValue(row.getCell(7)));    // H
                dto.setSexo(getStringValue(row.getCell(8)));             // I

                // Procesamiento especial para fecha
                Cell fechaCell = row.getCell(9);                          // J
                if (fechaCell != null) {
                    if (fechaCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(fechaCell)) {
                        // Si es una fecha de Excel formateada
                        java.util.Date fechaUtil = fechaCell.getDateCellValue();
                        dto.setFechaNacimiento(new java.sql.Date(fechaUtil.getTime()));
                    } else {
                        // Si es un string, intentar parsear
                        String fechaStr = getStringValue(fechaCell);
                        if (fechaStr != null && !fechaStr.isEmpty()) {
                            try {
                                // Parsear fecha en formato "yyyy-MM-dd HH:mm:ss" o similar
                                LocalDateTime dateTime = LocalDateTime.parse(fechaStr,
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                dto.setFechaNacimiento(java.sql.Date.valueOf(dateTime.toLocalDate()));
                            } catch (DateTimeParseException e1) {
                                try {
                                    // Parsear solo fecha "yyyy-MM-dd"
                                    LocalDate date = LocalDate.parse(fechaStr.split(" ")[0]);
                                    dto.setFechaNacimiento(java.sql.Date.valueOf(date));
                                } catch (Exception e2) {
                                    // Si no se puede parsear, se deja null
                                    dto.setFechaNacimiento(null);
                                }
                            }
                        }
                    }
                }

                dto.setCodigoPostal(getStringValue(row.getCell(10)));     // K

                // Solo agregar si tiene al menos un dato no nulo
                if (hasAnyData(dto)) {
                    catalogo.add(dto);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el archivo Excel", e);
        }

        return catalogo;
    }

    // Método auxiliar para verificar si una fila está vacía
    private boolean isEmptyRow(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    // Método auxiliar para verificar si el DTO tiene al menos un dato
    private boolean hasAnyData(CatalogoDatos dto) {
        return dto.getCategoriaVehiculo() != null ||
                dto.getTipoVehiculo() != null ||
                dto.getAno() != null ||
                dto.getMarca() != null ||
                dto.getModelo() != null ||
                dto.getDescripcion() != null ||
                dto.getUso() != null ||
                dto.getNombreCompleto() != null ||
                dto.getSexo() != null ||
                dto.getFechaNacimiento() != null;
    }
    private String getStringValue(Cell cell) {
        if (cell == null) return null;

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toLocalDate().format(DATE_FORMATTER);
                }
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return null;
        }
    }

    private Integer getIntValue(Cell cell) {
        if (cell == null) return null;

        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            case STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue().trim());
                } catch (NumberFormatException e) {
                    return null;
                }
            default:
                return null;
        }
    }

    private LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) return null;
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
}