package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.Career;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CareerRespository extends MongoRepository<Career, String> {

    // ✔️ Exacto
    Optional<Career> findByNombre(String nombre);

    // 🔥 NECESARIO para el Excel (sin problemas por mayúsculas / espacios)
    Optional<Career> findByNombreIgnoreCase(String nombre);
}
