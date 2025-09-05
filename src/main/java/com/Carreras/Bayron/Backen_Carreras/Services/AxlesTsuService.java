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

    public List<AxlesTsu> findAll() {
        return axlesTsuRepository.findAll();
    }

    public Optional<AxlesTsu> findById(String id) {
        return axlesTsuRepository.findById(id);
    }

    public AxlesTsu save(AxlesTsu axlesTsu) {
        return axlesTsuRepository.save(axlesTsu);
    }

    public void deleteById(String id) {
        axlesTsuRepository.deleteById(id);
    }

    public List<AxlesTsu> findByCalCareerId(String calCareerId) {
        return axlesTsuRepository.findByCalCareerId(calCareerId);
    }
}
