package com.sb.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.web.dao.IEmployeeRepository;
import com.sb.web.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository empDao;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return empDao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.saveAndFlush(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return empDao.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return empDao.findById(id);
	}

	@Override
	public void deleteEmployee(Long id) {
		empDao.deleteById(id);
	}
	
}
