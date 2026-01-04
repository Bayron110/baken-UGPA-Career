package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;
import com.Carreras.Bayron.Backen_Carreras.Repository.docentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class docenteServicies {

    @Autowired
    private docentesRepository docentesRepository;

    // Crear o actualizar un docente
    public docentes saveDocente(docentes docente) {
        return docentesRepository.save(docente);
    }

    // Obtener todos los docentes
    public List<docentes> getAllDocentes() {
        return docentesRepository.findAll();
    }

    // Buscar docente por ID
    public Optional<docentes> getDocenteById(String id) {
        return docentesRepository.findById(id);
    }

    // Eliminar docente por ID
    public void deleteDocente(String id) {
        docentesRepository.deleteById(id);
    }

    // Verificar si existe un docente por nombre (ejemplo adicional)
    public boolean existsByNombre(String nombre) {
        return docentesRepository.findAll()
                .stream()
                .anyMatch(d -> d.getNombre().equalsIgnoreCase(nombre));
    }
}