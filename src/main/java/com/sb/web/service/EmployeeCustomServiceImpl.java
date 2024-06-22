package com.sb.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.web.dao.IEmployeeRepository;
import com.sb.web.entity.Employee;

@Service
public class EmployeeCustomServiceImpl implements IEmployeeCustomService {

	@Autowired
	IEmployeeRepository empDao;
	
	
	@Override
	public void updateAllEmployees(List<Employee> empList) {
		
		/*
		 * empList.stream() .map(e -> empDao.saveAndFlush(e))
		 * .collect(Collectors.toList());
		 */
		
		for(Employee e : empList) {
			System.out.println("Updating::"+e.toString());
			empDao.saveAndFlush(e);
		}
		
	}

}
