package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCareerRepository extends MongoRepository<TypeCareer, String> {
}
