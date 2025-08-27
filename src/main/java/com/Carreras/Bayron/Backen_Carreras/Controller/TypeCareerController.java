package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;

import com.Carreras.Bayron.Backen_Carreras.Services.TypeCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-career")
public class TypeCareerController {

    @Autowired
    private TypeCareerService typeCareerService;

    @GetMapping
    public List<TypeCareer> getAllTypeCareers() {
        return typeCareerService.findAll();
    }

    @GetMapping("/{id}")
    public TypeCareer getTypeCareerById(@PathVariable Long id) {
        return typeCareerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de carrera no encontrado con ID: " + id));
    }

    @PostMapping
    public TypeCareer createTypeCareer(@RequestBody TypeCareer typeCareer) {
        return typeCareerService.save(typeCareer);
    }

    @PutMapping("/{id}")
    public TypeCareer updateTypeCareer(@PathVariable Long id, @RequestBody TypeCareer typeCareer) {
        return typeCareerService.update(id, typeCareer);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeCareer(@PathVariable Long id) {
        typeCareerService.deleteById(id);
    }
}
