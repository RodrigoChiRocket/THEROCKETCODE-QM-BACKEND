package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.domain.model.CatalogoDatos;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelProcessorService {
    List<CatalogoDatos> procesarArchivoExcel(MultipartFile archivo);
}
