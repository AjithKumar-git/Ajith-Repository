package com.cap.Assignment1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cap.Assignment1.Repository.EmployeeRepository;
import com.cap.Assignment1.models.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
    
	public List<Employee> addEmployee(Employee employee){
		
		employeeRepository.save(employee);
		List<Employee> emplist=employeeRepository.findAll();
		
		return emplist;		
	}

	public List<Employee> viewEmployees(){
		List<Employee> emplist=employeeRepository.findAll();
		return emplist;
	}
	
	public Optional<Employee> viewEmployee(int id){
		java.util.Optional<Employee> empl=employeeRepository.findById(id);
		return empl;
	}
	
	public Optional<Employee> deleteEmployee(int id){
		 java.util.Optional<Employee> empl=employeeRepository.findById(id);
		 if(empl.isPresent()) {
			 employeeRepository.deleteById(id);
		 }
		 return empl;
    }
	
	public Optional<Employee> updateEmployee(Employee employee){
		java.util.Optional<Employee> employ=employeeRepository.findById(employee.getEmployeeId());
		if(employ.isPresent()) {
			Employee employee1=employ.get();
			employee1.setAddress(employee.getAddress());
			employee1.setFirstname(employee.getFirstname());
			employee1.setLastname(employee.getLastname());
			employee1.setSalary(employee.getSalary());
			Employee updatedEmployee=employeeRepository.save(employee1);
			return Optional.of(updatedEmployee);						
		}
		else {
			return null;
		}
		
	}
	
	public List<Employee> findAllLkeString(String likeString){
		List<Employee> likeStringEmpList=employeeRepository.findAllLikeString(likeString);
		
			return likeStringEmpList; 
		
	}
	public int sumEmployeeSalary() {
		int sumSalary=employeeRepository.sumSalary();
		return sumSalary;
	}
	
	public int minEmployeeSalary() {
		int sumSalary=employeeRepository.minSalary();
		return sumSalary;
	}
	
	public int maxEmployeeSalary() {
		int sumSalary=employeeRepository.maxSalary();
		return sumSalary;
	}
	
	public List<Employee> findByFirstNameAsc(){
		List<Employee> emplist =employeeRepository.sortByFirstNameAsc();
		return emplist;
	}
	
	public List<Employee> sortByFirstNamedesc(){
		List<Employee> emplist =employeeRepository.sortByFirstNamedesc();
		return emplist;
	}
	
	
	
	
	
}
