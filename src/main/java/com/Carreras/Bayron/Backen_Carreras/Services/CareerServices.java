package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Repository.CareerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerServices {

    @Autowired
    private CareerRespository careerRepository;

    public List<Career> findAll() {
        return careerRepository.findAll();
    }

    public Optional<Career> findById(String id) {
        return careerRepository.findById(id);
    }

    public Career save(Career career) {
        return careerRepository.save(career);
    }

    public Career update(String id, Career updatedCareer) {
        return careerRepository.findById(id)
                .map(career -> {
                    career.setNombre(updatedCareer.getNombre());
                    // ⭐ CAMBIO: Ahora actualiza la lista de capacitaciones
                    career.setCapacitaciones(updatedCareer.getCapacitaciones());
                    career.setCapacitaciones(updatedCareer.getCapacitaciones());
                    return careerRepository.save(career);
                })
                .orElseThrow(() -> new RuntimeException("Career no encontrado con id: " + id));
    }

    public void deleteById(String id) {
        careerRepository.deleteById(id);
    }
}