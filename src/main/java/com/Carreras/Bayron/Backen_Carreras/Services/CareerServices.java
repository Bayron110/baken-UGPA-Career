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
    private CareerRespository careerRespository;

    public Career guardarCarrera(Career career){
        return careerRespository.save(career);
    }
    public List<Career> obtenerTodasLasCarreras() {
        return careerRespository.findAll();
    }

    // Obtener una carrera por ID
    public Optional<Career> obtenerCarreraPorId(Long id) {
        return careerRespository.findById(id);
    }

    // Editar el nombre de una carrera
    public Career editarCarrera(Long id, String nuevoNombre) {
        return careerRespository.findById(id)
                .map(carrera -> {
                    carrera.setNombre(nuevoNombre);
                    return careerRespository.save(carrera);
                })
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada con ID: " + id));
    }

    // Eliminar una carrera por ID
    public void eliminarCarrera(Long id) {
        if (careerRespository.existsById(id)) {
            careerRespository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar. Carrera no encontrada con ID: " + id);
        }
    }
}
