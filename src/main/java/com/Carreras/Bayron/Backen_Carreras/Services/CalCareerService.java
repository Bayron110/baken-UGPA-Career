package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.CalCareer;
import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;
import com.Carreras.Bayron.Backen_Carreras.Repository.CalCareerRepository;
import com.Carreras.Bayron.Backen_Carreras.Repository.TypeCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CalCareerService {

    @Autowired
    private CalCareerRepository calCareerRepository;
    @Autowired
    private TypeCareerRepository typeCareerRepository;

    public List<CalCareer> findAll() { return calCareerRepository.findAll(); }
    public Optional<CalCareer> findById(Long id) { return calCareerRepository.findById(id); }

    public CalCareer save(CalCareer calCareer) {
        if (calCareer.getTypeCareer() == null || calCareer.getTypeCareer().getId() == null) {
            throw new RuntimeException("Debe proporcionar un ID válido para TypeCareer");
        }

        TypeCareer typeCareer = typeCareerRepository.findById(calCareer.getTypeCareer().getId())
                .orElseThrow(() -> new RuntimeException("Tipo de carrera no encontrado con ID: " + calCareer.getTypeCareer().getId()));

        calCareer.setTypeCareer(typeCareer);
        return calCareerRepository.save(calCareer);
    }

    public CalCareer update(Long id, CalCareer updatedCalCareer) {
        return calCareerRepository.findById(id)
                .map(calCareer -> {
                    calCareer.setCareer(updatedCalCareer.getCareer());
                    calCareer.setTypeCareer(updatedCalCareer.getTypeCareer());
                    calCareer.setFechaActual(updatedCalCareer.getFechaActual());
                    calCareer.setFechaFin(updatedCalCareer.getFechaFin());
                    return calCareerRepository.save(calCareer);
                })
                .orElseThrow(() -> new RuntimeException("CalCareer no encontrado con id: " + id));
    }

    public void deleteById(Long id) { calCareerRepository.deleteById(id); }
}
