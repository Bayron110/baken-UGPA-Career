package com.Carreras.Bayron.Backen_Carreras.Repository;
import org.springframework.stereotype.Repository;
import com.Carreras.Bayron.Backen_Carreras.Entity.TypeCareer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TypeCareerRepository extends JpaRepository<TypeCareer, Long> {
}
