package com.cts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.salary>?1")
	public List<Employee> searchEmployeBySal(int salary);
	
	@Query("select e from Employee e where e.id>:id")
	public List<Employee> searchEmployeeById(int id);
	
	@Query("select max(e.salary) from Employee e")
	public int findMaxSal();
	
	@Query("select upper(e.name) from Employee e")
	public List<String> changeToUpperCase();
	
	
	public Employee readByName(String name);
	
	public List<Employee> findByNameAndSalary(String name,int salary);
	
	public List<Employee> findByNameOrSalary(String name,int salary);
	
	public List<Employee> findBySalaryGreaterThan(int salary);
	
	public List<Employee> findBySalaryLessThan(int salary);
	
	public List<Employee> findBySalaryBetween(int start,int end);
	
	public List<Employee> findByNameLike(String p);
	
	public List<Employee> findByNameNotLike(String p);
	
	public List<Employee> findByOrderBySalaryAsc();
	
	public List<Employee> findBySalaryIn(List<Integer> list);
	
	public List<Employee> findBySalaryNotIn(List<Integer> list);
	
	public List<Employee> findByNameIsNull();
	
	public List<Employee> findByNameNotNull();
}
