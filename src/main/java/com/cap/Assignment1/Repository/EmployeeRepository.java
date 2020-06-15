package com.cap.Assignment1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.Assignment1.models.Employee;

@Repository("EmployeeDBDao")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value="select * from Employee e where e.firstname LIKE ?1%",nativeQuery = true)
	public List<Employee> findAllLikeString(String likeString);
	
	@Query(value="select sum(e.salary) from Employee e",nativeQuery = true)
	public Integer sumSalary();
	
	@Query(value="select min(e.salary) from Employee e",nativeQuery = true)
	public Integer minSalary();
	
	@Query(value="select max(e.salary) from Employee e",nativeQuery = true)
	public Integer maxSalary();
	
	
}
