package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;

import com.Carreras.Bayron.Backen_Carreras.Repository.CareerRespository;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private CareerRespository careerRepository;

    public Docente crear(Docente docente) {

        // 🔒 Validar que la carrera exista
        Career career = careerRepository.findById(docente.getCareerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "La carrera seleccionada no existe"
                ));

        try {
            return docenteRepository.save(docente);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Ya existe un docente con esa cédula"
            );
        }
    }

    public List<Docente> obtenerPorCarrera(String careerId) {
        return docenteRepository.findByCareerId(careerId);
    }
}
