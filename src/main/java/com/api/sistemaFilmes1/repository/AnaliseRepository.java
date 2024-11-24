package com.api.sistemaFilmes1.repository;

import com.api.sistemaFilmes1.data.AnaliseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Integer> {
   AnaliseEntity findByFilmeId(Integer filmeId);
    
}
