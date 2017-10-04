package com.sample.springHibernateJsf.service;

import java.util.List;

import com.sample.springHibernateJsf.entity.*;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public void addEmployee(Employee employee);
	public void deleteEmployee(Long Id);
	public int updateEmployee(Employee employee);
	
	public String editAction(Employee employee);
	public String saveAction();
}
