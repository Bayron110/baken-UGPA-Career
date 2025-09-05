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
    public Optional<AxlesSuperior> findById(String id) {
        return axlesSuperiorRepository.findById(id);
    }

    // Guardar o actualizar
    public AxlesSuperior save(AxlesSuperior axlesSuperior) {
        return axlesSuperiorRepository.save(axlesSuperior);
    }

    // Eliminar por ID
    public void deleteById(String id) {
        axlesSuperiorRepository.deleteById(id);
    }
    public List<AxlesSuperior> findByCalCareerId(String calCareerId) {
        return axlesSuperiorRepository.findByCalCareerId(calCareerId);
    }

}
