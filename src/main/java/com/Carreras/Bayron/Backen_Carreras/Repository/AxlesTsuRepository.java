package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AxlesTsuRepository extends JpaRepository<AxlesTsu, Long> {
    List<AxlesTsu> findByCalCareerId(Long calCareerId);

}