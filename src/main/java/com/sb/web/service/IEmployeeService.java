package com.sb.web.service;

import java.util.List;
import java.util.Optional;

import com.sb.web.entity.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Optional<Employee> getEmployeeById(Long id);
	public void deleteEmployee(Long id);
	
}
