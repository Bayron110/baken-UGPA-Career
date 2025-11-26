package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    public List<Docente> findByCarrera(String carreraId) {
        return docenteRepository.findByCarreraId(carreraId);
    }

    public Docente toggleParticipacion(String id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        docente.setParticipacionCapacitacion(!docente.getParticipacionCapacitacion());
        return docenteRepository.save(docente);
    }
}