package com.sb.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.web.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findById(Long id);

	void deleteById(Long id);
	
}
