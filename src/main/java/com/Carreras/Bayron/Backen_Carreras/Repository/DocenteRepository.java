package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.Docente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DocenteRepository extends MongoRepository<Docente, String> {

    List<Docente> findByCareerId(String careerId);

    Optional<Docente> findByCedula(String cedula);
}
