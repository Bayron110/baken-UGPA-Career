package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Repository.CareerRespository;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocenteRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteExcelService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private CareerRespository careerRepository;

    public List<Docente> cargarDesdeExcel(MultipartFile file) {

        List<Docente> docentesGuardados = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String nombre = row.getCell(0).getStringCellValue().trim();
                String cedula = row.getCell(1).getStringCellValue().trim();
                String formacion = row.getCell(2).getStringCellValue().trim();
                String carreraNombre = row.getCell(3).getStringCellValue().trim();

                Career career = careerRepository.findByNombre(carreraNombre)
                        .orElseThrow(() ->
                                new RuntimeException("Carrera no existe: " + carreraNombre)
                        );

                Docente docente = docenteRepository.findByCedula(cedula)
                        .orElse(new Docente());

                docente.setNombre(nombre);
                docente.setCedula(cedula);
                docente.setFormacion(formacion);
                docente.setCarreraId(career.getId());

                docentesGuardados.add(docenteRepository.save(docente));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error procesando el archivo Excel", e);
        }

        return docentesGuardados;
    }
}
