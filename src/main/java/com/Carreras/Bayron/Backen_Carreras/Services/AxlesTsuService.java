package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import com.Carreras.Bayron.Backen_Carreras.Repository.AxlesTsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AxlesTsuService {

    private final AxlesTsuRepository axlesTsuRepository;

    @Autowired
    public AxlesTsuService(AxlesTsuRepository axlesTsuRepository) {
        this.axlesTsuRepository = axlesTsuRepository;
    }

    // Obtener todos los registros
    public List<AxlesTsu> findAll() {
        return axlesTsuRepository.findAll();
    }

    // Obtener por ID
    public Optional<AxlesTsu> findById(Long id) {
        return axlesTsuRepository.findById(id);
    }

    // Guardar o actualizar
    public AxlesTsu save(AxlesTsu axlesTsu) {
        return axlesTsuRepository.save(axlesTsu);
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        axlesTsuRepository.deleteById(id);
    }

    // Buscar por calCareerId (si aplica)
    public List<AxlesTsu> findByCalCareerId(Long calCareerId) {
        return axlesTsuRepository.findByCalCareerId(calCareerId);
    }
}