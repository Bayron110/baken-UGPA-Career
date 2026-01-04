package com.Carreras.Bayron.Backen_Carreras.Services;

import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;
import com.Carreras.Bayron.Backen_Carreras.Repository.docentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class docenteServicies {

    @Autowired
    private docentesRepository docentesRepository;

    // ✅ Crear docente (valida cédula única)
    public docentes crearDocente(docentes docente) {
        Optional<docentes> existente = docentesRepository.findByCedula(docente.getCedula());
        if (existente.isPresent()) {
            throw new RuntimeException("Ya existe un docente con esa cédula");
        }
        return docentesRepository.save(docente);
    }

    // ✅ Actualizar docente
    public docentes actualizarDocente(String id, docentes docente) {
        docentes existente = docentesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        existente.setNombresCompletos(docente.getNombresCompletos());
        existente.setCedula(docente.getCedula());
        existente.setFormacionActual(docente.getFormacionActual());
        existente.setNivel(docente.getNivel());
        existente.setUniversidad(docente.getUniversidad());
        existente.setEstado(docente.getEstado());
        existente.setPeriodo(docente.getPeriodo());
        existente.setCareerId(docente.getCareerId());

        return docentesRepository.save(existente);
    }

    // ✅ Obtener todos
    public List<docentes> obtenerTodos() {
        return docentesRepository.findAll();
    }

    // ✅ Obtener por ID
    public Optional<docentes> obtenerPorId(String id) {
        return docentesRepository.findById(id);
    }

    // ✅ Obtener por carrera
    public List<docentes> obtenerPorCarrera(String careerId) {
        return docentesRepository.findByCareerId(careerId);
    }

    // ✅ Eliminar
    public void eliminar(String id) {
        docentesRepository.deleteById(id);
    }
}
