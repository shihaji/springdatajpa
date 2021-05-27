package com.cts;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EntityManager em;

	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);

	}

	public void savelAllEmp(List<Employee> list) {

		employeeRepository.saveAll(list);

	}

	public Employee findEmployee(int id) {

		return employeeRepository.findById(id).get();
	}

	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);

	}

	public List<Employee> sortEmpBySal() {

		return employeeRepository.findAll(Sort.by("salary"));
	}

	public List<Employee> getEmployeeBySal(int salary) {

		return employeeRepository.searchEmployeBySal(salary);
	}

	public List<Employee> getEmployeeById(int id) {

		return employeeRepository.searchEmployeeById(id);
	}

	public int getMaxSal() {

		return employeeRepository.findMaxSal();
	}

	public List<String> getEmpUpperCase() {

		return employeeRepository.changeToUpperCase();
	}

	public Employee getByName(String name) {

		return employeeRepository.readByName(name);
	}

	public List<Employee> getByNameSalary(String name, int salary) {

		return employeeRepository.findByNameAndSalary(name, salary);
	}

	public List<Employee> getByNameOrSalary(String name, int salary) {

		return employeeRepository.findByNameOrSalary(name, salary);
	}

	public List<Employee> getEmployeeSalaryBased(int salary) {
		return employeeRepository.findBySalaryGreaterThan(salary);
	}

	public List<Employee> getEmployeeLessSalaryBased(int salary) {
		return employeeRepository.findBySalaryLessThan(salary);
	}

	public List<Employee> getSalaryRange(int start, int end) {
		return employeeRepository.findBySalaryBetween(start, end);
	}

	public List<Employee> getEmployeePattern(String p) {

		return employeeRepository.findByNameLike(p);
	}

	public List<Employee> getEmployeeExPattern(String p) {

		return employeeRepository.findByNameNotLike(p);
	}

	public List<Employee> sortBySal() {

		return employeeRepository.findByOrderBySalaryAsc();
	}

	public List<Employee> getEmpBySal(List<Integer> list) {

		return employeeRepository.findBySalaryIn(list);
	}

	public List<Employee> getEmpBySalNot(List<Integer> list) {

		return employeeRepository.findBySalaryNotIn(list);
	}
	
	public List<Employee> getNullEmp(){
		
		return employeeRepository.findByNameIsNull();
		
	}
	
    public List<Employee> getNoNullEmp(){
		
		return employeeRepository.findByNameNotNull();
		
	}
	
    
    public List<Employee> getEmpCriteria(){
    	
    	CriteriaBuilder cb=em.getCriteriaBuilder();
    	
    	CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
    	
    	Root<Employee> root=cq.from(Employee.class);
    	
    	cq.select(root);
    	
    	TypedQuery<Employee> tq=em.createQuery(cq);
    	
    	return tq.getResultList();
    }
    
    public Employee getEmpByNameCritera(String name) {
    	
        CriteriaBuilder cb=em.getCriteriaBuilder();
    	
    	CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
    	
    	Root<Employee> root=cq.from(Employee.class);
    	
    	cq.select(root);
    	
    	Path<String> path=root.get("name");
    	
    	Predicate p=cb.equal(path,name);
    	
    	cq.where(p);
    	
    	TypedQuery<Employee> tq=em.createQuery(cq);
    	
    	return tq.getSingleResult();
    	
    	
    }
    
 public List<Employee> getEmpByNamePatternCritera(String name) {
    	
        CriteriaBuilder cb=em.getCriteriaBuilder();
    	
    	CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
    	
    	Root<Employee> root=cq.from(Employee.class);
    	
    	cq.select(root);
    	
    	Path<String> path=root.get("name");
    	
    	Predicate p=cb.like(path,name+"%");
    	
    	cq.where(p);
    	
    	TypedQuery<Employee> tq=em.createQuery(cq);
    	
    	return tq.getResultList();
    	
    	
    }
 
 
 
 public List<Employee> getEmpBySalCriteria(int salary){
	 
	 
	 CriteriaBuilder cb=em.getCriteriaBuilder();
 	
 	CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
 	
 	Root<Employee> root=cq.from(Employee.class);
 	
 	cq.select(root);
 	
 	Path<Integer> path=root.get("salary");
 	
 	Predicate p=cb.greaterThan(path, salary);
	
 	cq.where(p);
 	
    TypedQuery<Employee> tq=em.createQuery(cq);
 	
	 return tq.getResultList();
 }
    
    
    
    
	
}
