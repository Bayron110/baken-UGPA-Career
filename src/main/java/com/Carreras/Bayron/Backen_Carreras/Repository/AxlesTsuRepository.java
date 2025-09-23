package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AxlesTsuRepository extends MongoRepository<AxlesTsu, String> {
    List<AxlesTsu> findByCalCareerId(String calCareerId);
}
