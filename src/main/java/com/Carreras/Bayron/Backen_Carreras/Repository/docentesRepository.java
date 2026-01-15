package com.Carreras.Bayron.Backen_Carreras.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;

import java.util.List;


@Repository
public interface docentesRepository  extends MongoRepository<docentes, String> {
    List<docentes> findByCarreraId(String carreraId);

    docentes findTopByOrderBySecuenciaDesc();
}
