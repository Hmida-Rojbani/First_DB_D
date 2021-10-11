package de.tekup.first.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getEmployeeById(@PathVariable int id) {
		return empService.getById(id);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Erreur in saving in DB :"+e.getMessage());
				
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(e.getMessage());
				
	}

}
