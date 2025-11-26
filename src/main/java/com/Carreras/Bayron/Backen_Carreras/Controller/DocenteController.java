package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public Docente create(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    @GetMapping("{carreraId}")
    public List<Docente> getByCarrera(@PathVariable String carreraId) {
        return docenteService.findByCarrera(carreraId);
    }

    @PutMapping("/{id}/participacion")
    public Docente toggleParticipacion(@PathVariable String id) {
        return docenteService.toggleParticipacion(id);
    }
}