package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;
import com.Carreras.Bayron.Backen_Carreras.Services.docenteServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
public class docenteController {

    @Autowired
    private docenteServicies docenteServicies;

    // ✅ Crear docente
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody docentes docente) {
        try {
            return ResponseEntity.ok(docenteServicies.crearDocente(docente));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Obtener todos
    @GetMapping
    public ResponseEntity<List<docentes>> listar() {
        return ResponseEntity.ok(docenteServicies.obtenerTodos());
    }

    // ✅ Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable String id) {
        return docenteServicies.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Obtener docentes por carrera
    @GetMapping("/carrera/{careerId}")
    public ResponseEntity<List<docentes>> obtenerPorCarrera(@PathVariable String careerId) {
        return ResponseEntity.ok(docenteServicies.obtenerPorCarrera(careerId));
    }

    // ✅ Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable String id,
            @RequestBody docentes docente) {
        try {
            return ResponseEntity.ok(docenteServicies.actualizarDocente(id, docente));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        docenteServicies.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
