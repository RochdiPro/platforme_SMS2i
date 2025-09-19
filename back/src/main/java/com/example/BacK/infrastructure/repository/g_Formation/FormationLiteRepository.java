package com.example.BacK.infrastructure.repository.g_Formation;

import com.example.BacK.domain.g_Formation.FormationLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FormationLiteRepository extends JpaRepository<FormationLite, Long>  {

    @Query("SELECT f FROM FormationLite f LEFT JOIN FETCH f.contenus")
    List<FormationLite> findAllWithContenus();


}
