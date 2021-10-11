package de.tekup.first.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.first.entities.EmployeeEntity;
import de.tekup.first.services.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeCtrl {
	
	private EmployeeService empService;
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getEmployees(){
		return empService.getAllEntity();
	}
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveEmployeeEntity(@RequestBody EmployeeEntity employeeEntity) {
		return empService.addToDB(employeeEntity);
	}

}
