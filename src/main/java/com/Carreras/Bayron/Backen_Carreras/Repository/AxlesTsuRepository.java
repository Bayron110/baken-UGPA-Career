package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesTsu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AxlesTsuRepository extends MongoRepository<AxlesTsu, String> {
    List<AxlesTsu> findByCalCareerId(String calCareerId);
}
