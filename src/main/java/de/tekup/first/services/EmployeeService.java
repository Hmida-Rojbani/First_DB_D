package de.tekup.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.first.entities.EmployeeEntity;
import de.tekup.first.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository empRepos;

	public List<EmployeeEntity> getAllEntity(){
		return empRepos.findAll();
	}

	public EmployeeEntity addToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}
	

}
