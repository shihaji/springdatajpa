package com.cts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
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
	
	
	public List<Employee> getEmployeeBySal(int salary){
		
		return employeeRepository.searchEmployeBySal(salary);
	}
	
	
    public List<Employee> getEmployeeById(int id){
		
		return employeeRepository.searchEmployeeById(id);
	}
    
    public int getMaxSal() {
    	
    	return employeeRepository.findMaxSal();
    }
    
    public List<String> getEmpUpperCase(){
    	
    	return employeeRepository.changeToUpperCase();
    }
	
}
