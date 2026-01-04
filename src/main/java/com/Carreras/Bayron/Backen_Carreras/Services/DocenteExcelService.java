package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Repository.CareerRespository;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocenteRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteExcelService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private CareerRespository careerRepository;

    public List<Docente> cargarDesdeExcel(MultipartFile file) {

        List<Docente> docentes = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String nombre = getCellValue(row.getCell(0));
                String cedula = getCellValue(row.getCell(1));
                String formacion = getCellValue(row.getCell(2));
                String carreraNombre = getCellValue(row.getCell(3));

                if (nombre.isEmpty() || cedula.isEmpty()) continue;

                Career career = careerRepository
                        .findByNombreIgnoreCase(carreraNombre.trim())
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST,
                                        "Carrera no existe: " + carreraNombre
                                )
                        );

                Docente docente = docenteRepository
                        .findByCedula(cedula)
                        .orElse(new Docente());

                docente.setNombre(nombre);
                docente.setCedula(cedula);
                docente.setFormacion(formacion);
                docente.setCarreraId(career.getId());

                docentes.add(docenteRepository.save(docente));
            }

        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error procesando el archivo Excel"
            );
        }

        return docentes;
    }

    // 🔒 MÉTODO SEGURO PARA EXCEL
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }
}
