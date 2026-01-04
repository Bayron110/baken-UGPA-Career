package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;
import com.Carreras.Bayron.Backen_Carreras.Services.docenteServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docentes")
public class docenteController {

    @Autowired
    private docenteServicies docenteServicies;

    // Crear un docente
    @PostMapping
    public ResponseEntity<docentes> createDocente(@RequestBody docentes docente) {
        docentes nuevoDocente = docenteServicies.saveDocente(docente);
        return ResponseEntity.ok(nuevoDocente);
    }

    // Obtener todos los docentes
    @GetMapping
    public ResponseEntity<List<docentes>> getAllDocentes() {
        List<docentes> lista = docenteServicies.getAllDocentes();
        return ResponseEntity.ok(lista);
    }

    // Obtener un docente por ID
    @GetMapping("/{id}")
    public ResponseEntity<docentes> getDocenteById(@PathVariable String id) {
        Optional<docentes> docente = docenteServicies.getDocenteById(id);
        return docente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un docente
    @PutMapping("/{id}")
    public ResponseEntity<docentes> updateDocente(@PathVariable String id, @RequestBody docentes docente) {
        Optional<docentes> existente = docenteServicies.getDocenteById(id);
        if (existente.isPresent()) {
            docente.setId(id);
            docentes actualizado = docenteServicies.saveDocente(docente);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un docente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable String id) {
        Optional<docentes> existente = docenteServicies.getDocenteById(id);
        if (existente.isPresent()) {
            docenteServicies.deleteDocente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}