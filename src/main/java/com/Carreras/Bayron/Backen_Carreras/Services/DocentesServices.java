package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocentesServices {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> findById(String id){
        return docenteRepository.findById(id);
    }

    public Docente save(Docente docente){
        return docenteRepository.save(docente);
    }

    public Docente update(String id, Docente updateDocente){
        return  docenteRepository.findById(id)
                .map(docente -> {
                    docente.setNombre(updateDocente.getNombre());
                    docente.setCedula(updateDocente.getCedula());
                    return docenteRepository.save(docente);
                })
                .orElseThrow(()-> new RuntimeException("Docente no encontrado: " + id));

    }

    public void deleteById(String id){
        docenteRepository.deleteById(id);
    }
}
