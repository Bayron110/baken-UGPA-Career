package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.CalCareer;
import com.Carreras.Bayron.Backen_Carreras.Services.CalCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cal-career")
public class CalCareerController {

    @Autowired
    private CalCareerService calCareerService;

    @GetMapping
    public List<CalCareer> getAllCalCareers() { return calCareerService.findAll(); }

    @GetMapping("/{id}")
    public CalCareer getCalCareerById(@PathVariable String id) {
        return calCareerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro CalCareer no encontrado con ID: " + id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CalCareer createCalCareer(@RequestBody CalCareer calCareer) {
        return calCareerService.save(calCareer);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public CalCareer updateCalCareer(@PathVariable String id, @RequestBody CalCareer calCareer) {
        return calCareerService.update(id, calCareer);
    }

    @DeleteMapping("/{id}")
    public void deleteCalCareer(@PathVariable String id) {
        calCareerService.deleteById(id);
    }
}
