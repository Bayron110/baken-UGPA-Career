package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesSuperior;
import com.Carreras.Bayron.Backen_Carreras.Services.AxlesSuperiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AxlesSuperiorController {

    private final AxlesSuperiorService axlesSuperiorService;

    @Autowired
    public AxlesSuperiorController(AxlesSuperiorService axlesSuperiorService) {
        this.axlesSuperiorService = axlesSuperiorService;
    }

    @GetMapping("/axles-superior")
    public ResponseEntity<List<AxlesSuperior>> getAll() {
        try {
            List<AxlesSuperior> axles = axlesSuperiorService.findAll();
            return ResponseEntity.ok(axles);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/axles-superior/{id}")
    public ResponseEntity<AxlesSuperior> getById(@PathVariable String id) {
        try {
            Optional<AxlesSuperior> axle = axlesSuperiorService.findById(id);
            return axle.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/axles-superior")
    public ResponseEntity<AxlesSuperior> save(@RequestBody AxlesSuperior axlesSuperior) {
        try {
            AxlesSuperior savedAxle = axlesSuperiorService.save(axlesSuperior);
            return ResponseEntity.ok(savedAxle);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/axles-superior/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            if (axlesSuperiorService.findById(id).isPresent()) {
                axlesSuperiorService.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/axles-superior/career/{calCareerId}")
    public ResponseEntity<List<AxlesSuperior>> getByCalCareerId(@PathVariable String calCareerId) {
        try {
            List<AxlesSuperior> axles = axlesSuperiorService.findByCalCareerId(calCareerId);
            return ResponseEntity.ok(axles);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/axles-superior/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("AxlesSuperior Controller is working!");
    }
}
