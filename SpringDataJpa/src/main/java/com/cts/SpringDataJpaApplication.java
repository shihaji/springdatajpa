package com.cts;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringDataJpaApplication.class, args);
		
		EmployeeService empSer=ctx.getBean(EmployeeService.class);
		
	   System.out.println(empSer.getEmpBySalCriteria(50000));
	    		 
	    		 
	    
	   
	}

}
