package com.sb.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.web.entity.Employee;
import com.sb.web.entity.EmployeeGroup;
import com.sb.web.exception.EmployeeException;
import com.sb.web.service.IEmployeeCustomService;
import com.sb.web.service.IEmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	IEmployeeService empService;
	
	@Autowired
	IEmployeeCustomService empCustService;
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}
	
	@GetMapping("/listEmployees")
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
		return empService.getEmployeeById(id);
	}
	
	/*
	 * @PutMapping("/updateEmployee/{id}") public Employee
	 * updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
	 * Optional<Employee> emp = empService.getEmployeeById(id); Employee ee =
	 * emp.get(); if(emp.isPresent()) { ee.setFirstName(employee.getFirstName());
	 * ee.setLastName(employee.getLastName()); ee.setEmail(employee.getEmail()); }
	 * return empService.updateEmployee(ee); }
	 */
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @ModelAttribute Employee employee) throws Exception {
		Optional<Employee> emp = empService.getEmployeeById(id);
		String fileName = "D:\\KK Files\\work\\TestFile.txt";
		try (Scanner file = new Scanner(new File(fileName))) {
			if (file.hasNextLine()) {
			    	System.out.println("### BEGIN PRINTING LINE ####");
			    	System.out.println(file.nextLine());
			    	System.out.println("### END PRINTING LINE ####");
			    }
		}catch(FileNotFoundException e) {
				throw new Exception("FileNotFoundException!!");
		}
		
		Employee ee = emp.get();
		try {
			if(emp.isPresent()) {
				ee.setFirstName(employee.getFirstName());
				ee.setLastName(employee.getLastName());
				ee.setEmail(employee.getEmail());
				ee = empService.updateEmployee(ee);
			}
		}catch(Exception e) {
			throw new EmployeeException("Custom error:: Employee Exception Test Message!!");
		}
		
		return ResponseEntity.ok(ee);
	}
	
	
	  @PutMapping(path="/updateAllEmployees", consumes = MediaType.APPLICATION_JSON_VALUE) 
	  public void updateAllEmployees(@RequestBody EmployeeGroup employeeGroup) {
	  
//		  List<Employee> empList = requestParams.getJSONArray("employee").toList(); // org.json
		  
		  List<com.sb.web.entity.EmployeeGroup.Employee> empList = employeeGroup.getEmployeeList();
		  
		  empList.stream()
		  		.forEach(e -> System.out.println(e.toString()));
		  
			/*
			 * Gson gson = new Gson(); Type listType = new TypeToken<List<Employee>>()
			 * {}.getType(); List<Employee> personList = gson.fromJson(jsonArray, listType);
			 */
	  
	  }
	 
	
}
