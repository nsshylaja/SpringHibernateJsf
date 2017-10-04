package com.sample.springHibernateJsf.dao;

import java.util.List;

import com.sample.springHibernateJsf.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public void addEmployee(Employee employee);
	public void deleteEmployee(Long Id);
	public int updateEmployee(Employee employee);
	
}
