package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Services.CareerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CareerController {

    @Autowired
    private CareerServices careerServices;

    @GetMapping
    public List<Career> getAllCareers() {
        return careerServices.findAll();
    }

    @GetMapping("/{id}")
    public Career getCareerById(@PathVariable String id) {
        return careerServices.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada con ID: " + id));
    }

    @PostMapping
    public Career createCareer(@RequestBody Career career) {
        return careerServices.save(career);
    }

    @PutMapping("/{id}")
    public Career updateCareer(@PathVariable String id, @RequestBody Career career) {
        return careerServices.update(id, career);
    }

    @DeleteMapping("/{id}")
    public void deleteCareer(@PathVariable String id) {
        careerServices.deleteById(id);
    }

}
