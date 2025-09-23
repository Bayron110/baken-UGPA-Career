package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import com.Carreras.Bayron.Backen_Carreras.Services.AxlesTsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AxlesTsuController {

    private final AxlesTsuService axlesTsuService;

    @Autowired
    public AxlesTsuController(AxlesTsuService axlesTsuService) {
        this.axlesTsuService = axlesTsuService;
    }

    @GetMapping("/axles-tsu")
    public ResponseEntity<List<AxlesTsu>> getAll() {
        return ResponseEntity.ok(axlesTsuService.findAll());
    }

    @GetMapping("/axles-tsu/{id}")
    public ResponseEntity<AxlesTsu> getById(@PathVariable String id) {
        Optional<AxlesTsu> axle = axlesTsuService.findById(id);
        return axle.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/axles-tsu")
    public ResponseEntity<AxlesTsu> save(@RequestBody AxlesTsu axlesTsu) {
        return ResponseEntity.ok(axlesTsuService.save(axlesTsu));
    }

    @DeleteMapping("/axles-tsu/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (axlesTsuService.findById(id).isPresent()) {
            axlesTsuService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/axles-tsu/career/{calCareerId}")
    public ResponseEntity<List<AxlesTsu>> getByCalCareerId(@PathVariable String calCareerId) {
        return ResponseEntity.ok(axlesTsuService.findByCalCareerId(calCareerId));
    }

    @GetMapping("/axles-tsu/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("AxlesTsu Controller is working!");
    }
}
