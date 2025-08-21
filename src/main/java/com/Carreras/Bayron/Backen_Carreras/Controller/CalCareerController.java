package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.CalCareer;
import com.Carreras.Bayron.Backen_Carreras.Services.CalCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cal-career")
public class CalCareerController {

    @Autowired
    private CalCareerService calCareerService;

    // 🔍 Obtener todos
    @GetMapping
    public List<CalCareer> getAllCalCareers() {
        return calCareerService.getAllCalCareers();
    }

    // 🔍 Obtener por ID
    @GetMapping("/{id}")
    public Optional<CalCareer> getCalCareerById(@PathVariable Long id) {
        return calCareerService.getCalCareerById(id);
    }

    // 💾 Crear nuevo
    @PostMapping
    public CalCareer createCalCareer(@RequestBody CalCareer calCareer) {
        return calCareerService.saveCalCareer(calCareer);
    }

    // 📝 Actualizar existente
    @PutMapping("/{id}")
    public CalCareer updateCalCareer(@PathVariable Long id, @RequestBody CalCareer calCareer) {
        return calCareerService.updateCalCareer(id, calCareer);
    }

    // ❌ Eliminar por ID
    @DeleteMapping("/{id}")
    public boolean deleteCalCareer(@PathVariable Long id) {
        return calCareerService.deleteCalCareer(id);
    }
}