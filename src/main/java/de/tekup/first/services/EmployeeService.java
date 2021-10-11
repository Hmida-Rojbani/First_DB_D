package de.tekup.first.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

	public EmployeeEntity getById(int id) {
		Optional<EmployeeEntity> opt =  empRepos.findById(id);
		
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee with this id not found");
		
		return opt.orElseThrow(()->new NoSuchElementException("Employee with this id not found"));
	}

	public EmployeeEntity updateById(int id, EmployeeEntity newEmployee) {
		//test Id exists
		EmployeeEntity employee = getById(id);
		if(newEmployee.getName()!=null)
			employee.setName(newEmployee.getName());
		if(newEmployee.getDob()!=null)
			employee.setDob(newEmployee.getDob());
		if(newEmployee.getEmail()!=null)
			employee.setEmail(newEmployee.getEmail());

		return empRepos.save(employee);
	}

	public EmployeeEntity deleteEmpById(int id) {
		EmployeeEntity employee = getById(id);
		empRepos.deleteById(id);
		return employee;
	}
	

}
