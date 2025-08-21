package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.CalCareer;
import com.Carreras.Bayron.Backen_Carreras.Repository.CalCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalCareerService {

    @Autowired
    private CalCareerRepository calCareerRepository;

    public List<CalCareer> getAllCalCareers() {
        return calCareerRepository.findAll();
    }

    public Optional<CalCareer> getCalCareerById(Long id) {
        return calCareerRepository.findById(id);
    }

    public CalCareer saveCalCareer(CalCareer calCareer) {
        return calCareerRepository.save(calCareer);
    }

    public CalCareer updateCalCareer(Long id, CalCareer updatedCalCareer) {
        return calCareerRepository.findById(id).map(existing -> {
            existing.setTypeCareerTipo(updatedCalCareer.getTypeCareerTipo());
            existing.setTypeCareerDuracion(updatedCalCareer.getTypeCareerDuracion());
            existing.setCareerId(updatedCalCareer.getCareerId());
            existing.setFechaActual(updatedCalCareer.getFechaActual());
            existing.setFechaFinal(updatedCalCareer.getFechaFinal());
            return calCareerRepository.save(existing);
        }).orElse(null);
    }

    public boolean deleteCalCareer(Long id) {
        if (calCareerRepository.existsById(id)) {
            calCareerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}