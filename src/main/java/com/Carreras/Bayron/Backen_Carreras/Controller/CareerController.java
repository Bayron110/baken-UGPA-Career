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

    // Endpoint para guardar una carrera
    @PostMapping
    public Career guardarCarrera(@RequestBody Career career) {
        return careerServices.guardarCarrera(career);
    }
    // Endpoint para obtener todas las carreras
    @GetMapping
    public List<Career> obtenerCarreras() {
        return careerServices.obtenerTodasLasCarreras();
    }
}