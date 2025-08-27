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

    public List<TypeCareer> findAll() {
        return typeCareerRepository.findAll();
    }

    public Optional<TypeCareer> findById(Long id) {
        return typeCareerRepository.findById(id);
    }

    public TypeCareer save(TypeCareer typeCareer) {
        return typeCareerRepository.save(typeCareer);
    }

    public TypeCareer update(Long id, TypeCareer updatedTypeCareer) {
        return typeCareerRepository.findById(id)
                .map(typeCareer -> {
                    typeCareer.setTipo(updatedTypeCareer.getTipo());
                    typeCareer.setDuracion(updatedTypeCareer.getDuracion());
                    return typeCareerRepository.save(typeCareer);
                })
                .orElseThrow(() -> new RuntimeException("TypeCareer no encontrado con id: " + id));
    }

    public void deleteById(Long id) {
        typeCareerRepository.deleteById(id);
    }
}
