package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesSuperior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AxlesSuperiorRespository extends JpaRepository<AxlesSuperior, Long> {
    List<AxlesSuperior> findByCalCareerId(Long calCareerId);

}
