package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.AxlesSuperior;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AxlesSuperiorRespository extends MongoRepository<AxlesSuperior, String> {
    List<AxlesSuperior> findByCalCareerId(String calCareerId);

}
