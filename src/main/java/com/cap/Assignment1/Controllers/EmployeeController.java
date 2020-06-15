package com.cap.Assignment1.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cap.Assignment1.Repository.AddressRepository;
import com.cap.Assignment1.Repository.EmployeeRepository;
import com.cap.Assignment1.Services.EmployeeService;
import com.cap.Assignment1.models.Address;
import com.cap.Assignment1.models.Employee;
import com.sun.el.stream.Optional;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee){
		
		List<Employee> emplist=employeeService.addEmployee(employee);
		
		if(emplist==null||emplist.isEmpty()) {
			return new ResponseEntity("Sorry!No employees found",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewEmployees")
	public ResponseEntity<List<Employee>> viewEmployees(){
		List<Employee> emplist=employeeService.viewEmployees();
		if(emplist==null||emplist.isEmpty()) {
			return new ResponseEntity("Sorry!No employees found",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployee/{id}")
	public ResponseEntity<Employee> viewEmployee(@PathVariable int id){
		java.util.Optional<Employee> empl=employeeService.viewEmployee(id);
		if(empl.isPresent()) {
			return new ResponseEntity<Employee>(empl.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity("Sorry!No employees found with the mentioned Id " + id,HttpStatus.NOT_FOUND);
		}
	}
	
	
	 @DeleteMapping("/deleteEmployee/{id}") 
	 public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		 java.util.Optional<Employee> emp=employeeService.deleteEmployee(id);
		 if(emp.isPresent()) {
		     return new ResponseEntity("Employee Deleted with the id "+id,HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<String>("Sorry!No employees found to delete with the mentioned Id " + id,HttpStatus.NOT_FOUND);
		 }
	 }
	 @PutMapping("/updateEmployee")
	 public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		 java.util.Optional<Employee> employ=employeeService.updateEmployee(employee);
		 if(employ.equals(null)) {
			 return new ResponseEntity("Sorry, No Employee is presented with the Id "+employee.getEmployeeId(),HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<Employee>(employ.get(),HttpStatus.OK);
		 }
		 
	 }
	 
	 @GetMapping("/likeString/{likeString}")
	 public ResponseEntity<List<Employee>> likeStringEmpList(@PathVariable String likeString){
		 List<Employee> likeStringEmpList=employeeService.findAllLkeString(likeString);
			if(likeStringEmpList==null||likeStringEmpList.isEmpty()) {
				return new ResponseEntity("Sorry!No employees found",HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<Employee>>(likeStringEmpList,HttpStatus.OK);

	 }
	 
	 @GetMapping("/sumEmployeeSalary")
	 public ResponseEntity<String> sumEmployeeSalary(){
		 int sumSalary=employeeService.sumEmployeeSalary();
		 if(sumSalary==0) {
			 return new ResponseEntity("Sorry!Unable to find sum of all Employee Salary",HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<String>("Total Employees Salary is " +sumSalary,HttpStatus.OK);
		 }
	 }
	 
	 @GetMapping("/minEmployeeSalary")
	 public ResponseEntity<String> minEmployeeSalary(){
		 int minSalary=employeeService.minEmployeeSalary();
		 
			 return new ResponseEntity("Minimum Salary in Employee Table is "+minSalary,HttpStatus.NOT_FOUND);
		 	 }
	 
	 @GetMapping("/maxEmployeeSalary")
	 public ResponseEntity<String> maxEmployeeSalary(){
		 int maxSalary=employeeService.maxEmployeeSalary();
		 
			 return new ResponseEntity("Maximum Salary in Employee Table is "+maxSalary,HttpStatus.NOT_FOUND);
		 	 }
	
	 
}
