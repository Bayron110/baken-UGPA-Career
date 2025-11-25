package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Services.DocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
    @Autowired
    private DocentesServices docentesServices;

    @GetMapping
    public List<Docente> getAllDocente(){
        return docentesServices.findAll();
    }

    @GetMapping("/{id}")
    public Docente getDocenteById(@PathVariable String id){
        return docentesServices.findById(id)
                .orElseThrow(()-> new RuntimeException("Docente no encontrado: "+ id));

    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Docente createDocente(@RequestBody Docente docente) {
        return docentesServices.save(docente);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Docente updateDocente(@PathVariable String id, @RequestBody Docente docente){
        return docentesServices.update(id, docente);
    }


    @DeleteMapping("/{id}")
    public void deleteDocente(@PathVariable String id){
        docentesServices.deleteById(id);
    }
}
