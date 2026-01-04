package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Services.DocenteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    // ✅ Crear docente vinculado a carrera
    @PostMapping
    public Docente crear(@Valid @RequestBody Docente docente) {
        return docenteService.crear(docente);
    }

    // ✅ Listar docentes por carrera
    @GetMapping("/carrera/{careerId}")
    public List<Docente> obtenerPorCarrera(@PathVariable String careerId) {
        return docenteService.obtenerPorCarrera(careerId);
    }
}
