package com.Carreras.Bayron.Backen_Carreras.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Carreras.Bayron.Backen_Carreras.Entity.docentes;

import java.util.List;
import java.util.Optional;


@Repository
public interface docentesRepository  extends MongoRepository<docentes, String> {
    List<docentes> findByCareerId(String careerId);
    Optional<docentes> findByCedula(String cedula);
}
