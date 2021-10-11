package de.tekup.first.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.first.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
