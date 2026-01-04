package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Services.DocenteExcelService;
import com.Carreras.Bayron.Backen_Carreras.Services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private DocenteExcelService docenteExcelService;

    @PostMapping
    public Docente create(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    @GetMapping("/carrera/{carreraId}")
    public List<Docente> getByCarrera(@PathVariable String carreraId) {
        return docenteService.findByCarrera(carreraId);
    }

    @GetMapping("/{id}")
    public Docente getById(@PathVariable String id) {
        return docenteService.findById(id);
    }

    @PostMapping(
            value = "/cargar-excel",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public List<Docente> cargarExcel(@RequestParam("file") MultipartFile file) {
        return docenteExcelService.cargarDesdeExcel(file);
    }
}
