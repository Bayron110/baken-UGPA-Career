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

    public docentes saveDocente(docentes docente) {

        if (docente.getId() == null) {

            docentes ultimo = docentesRepository.findTopByOrderBySecuenciaDesc();
            int siguiente = (ultimo == null) ? 1 : ultimo.getSecuencia() + 1;

            docente.setSecuencia(siguiente);
        }

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

    public List<docentes> getDocentesByCarrera(String carreraId) {
        return docentesRepository.findByCarreraId(carreraId);
    }
}
