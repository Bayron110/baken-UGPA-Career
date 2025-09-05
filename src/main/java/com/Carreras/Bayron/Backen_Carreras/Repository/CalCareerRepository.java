package com.Carreras.Bayron.Backen_Carreras.Repository;

import com.Carreras.Bayron.Backen_Carreras.Entity.CalCareer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalCareerRepository extends MongoRepository<CalCareer, String> {
}
