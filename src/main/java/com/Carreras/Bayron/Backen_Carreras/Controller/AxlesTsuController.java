package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import com.Carreras.Bayron.Backen_Carreras.Services.AxlesTsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/axles-tsu")
@CrossOrigin(origins = "*")
public class AxlesTsuController {

    private final AxlesTsuService axlesTsuService;

    @Autowired
    public AxlesTsuController(AxlesTsuService axlesTsuService) {
        this.axlesTsuService = axlesTsuService;
    }

    // Obtener todos los registros
    @GetMapping
    public List<AxlesTsu> getAll() {
        return axlesTsuService.findAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Optional<AxlesTsu> getById(@PathVariable Long id) {
        return axlesTsuService.findById(id);
    }

    // Crear o actualizar
    @PostMapping
    public AxlesTsu save(@RequestBody AxlesTsu axlesTsu) {
        return axlesTsuService.save(axlesTsu);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        axlesTsuService.deleteById(id);
    }

    // Buscar por calCareerId (si aplica)
    @GetMapping("/career/{calCareerId}")
    public List<AxlesTsu> getByCalCareerId(@PathVariable Long calCareerId) {
        return axlesTsuService.findByCalCareerId(calCareerId);
    }
}