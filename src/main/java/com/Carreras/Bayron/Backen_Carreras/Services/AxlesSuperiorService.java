package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesSuperior;
import com.Carreras.Bayron.Backen_Carreras.Repository.AxlesSuperiorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AxlesSuperiorService {

    private final AxlesSuperiorRespository axlesSuperiorRepository;

    @Autowired
    public AxlesSuperiorService(AxlesSuperiorRespository axlesSuperiorRepository) {
        this.axlesSuperiorRepository = axlesSuperiorRepository;
    }

    // Obtener todos los registros
    public List<AxlesSuperior> findAll() {
        return axlesSuperiorRepository.findAll();
    }

    // Obtener por ID
    public Optional<AxlesSuperior> findById(Long id) {
        return axlesSuperiorRepository.findById(id);
    }

    // Guardar o actualizar
    public AxlesSuperior save(AxlesSuperior axlesSuperior) {
        return axlesSuperiorRepository.save(axlesSuperior);
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        axlesSuperiorRepository.deleteById(id);
    }

    // Buscar por calCareerId
    public List<AxlesSuperior> findByCalCareerId(Long calCareerId) {
        return axlesSuperiorRepository.findByCalCareerId(calCareerId);
    }
}