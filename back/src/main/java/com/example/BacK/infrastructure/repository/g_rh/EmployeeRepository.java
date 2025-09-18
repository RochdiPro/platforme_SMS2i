package com.example.BacK.infrastructure.repository.g_rh;

import com.example.BacK.domain.g_RH.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}