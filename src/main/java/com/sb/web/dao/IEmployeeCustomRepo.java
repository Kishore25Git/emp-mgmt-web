package com.sb.web.dao;

import java.util.List;

import com.sb.web.entity.Employee;

public interface IEmployeeCustomRepo {

	public void updateAllEmployees(List<Employee> empList);
}
