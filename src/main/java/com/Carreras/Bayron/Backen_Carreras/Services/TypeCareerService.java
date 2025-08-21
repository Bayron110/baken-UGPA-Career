package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;
import com.Carreras.Bayron.Backen_Carreras.Repository.TypeCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCareerService {

    @Autowired
    private TypeCareerRepository typeCareerRepository;

    // 🔹 Crear nueva carrera
    public TypeCareer guardar(TypeCareer carrera) {
        return typeCareerRepository.save(carrera);
    }

    // 🔹 Obtener todas las carreras
    public List<TypeCareer> listarTodas() {
        return typeCareerRepository.findAll();
    }


    // 🔹 Actualizar carrera
    public TypeCareer actualizar(TypeCareer carrera) {
        return typeCareerRepository.save(carrera);
    }

    // 🔹 Eliminar por ID
    public void eliminar(Long id) {
        typeCareerRepository.deleteById(id);
    }
}