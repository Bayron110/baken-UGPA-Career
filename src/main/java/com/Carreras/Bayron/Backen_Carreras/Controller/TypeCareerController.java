package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;
import com.Carreras.Bayron.Backen_Carreras.Services.TypeCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-career")
public class TypeCareerController {

    @Autowired
    private TypeCareerService typeCareerService;

    @PostMapping
    public ResponseEntity<TypeCareer> guardar(@RequestBody TypeCareer carrera) {
        TypeCareer nuevaCarrera = typeCareerService.guardar(carrera);
        return ResponseEntity.ok(nuevaCarrera);
    }
    @GetMapping
    public List<TypeCareer> obtenerCarreras() {
        return typeCareerService.listarTodas();
    }
}