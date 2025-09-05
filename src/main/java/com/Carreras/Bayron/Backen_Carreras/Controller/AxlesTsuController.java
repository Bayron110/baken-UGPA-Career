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

    @GetMapping
    public List<AxlesTsu> getAll() {
        return axlesTsuService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AxlesTsu> getById(@PathVariable String id) {
        return axlesTsuService.findById(id);
    }

    @PostMapping
    public AxlesTsu save(@RequestBody AxlesTsu axlesTsu) {
        return axlesTsuService.save(axlesTsu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        axlesTsuService.deleteById(id);
    }

    @GetMapping("/career/{calCareerId}")
    public List<AxlesTsu> getByCalCareerId(@PathVariable String calCareerId) {
        return axlesTsuService.findByCalCareerId(calCareerId);
    }
}
