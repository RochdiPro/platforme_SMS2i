package com.example.BacK.infrastructure.repository.g_Formation;

import com.example.BacK.domain.g_Formation.Formation;
import com.example.BacK.domain.g_Formation.UserFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFormationRepository extends JpaRepository<UserFormation, Long> {

}
