package com.sample.springHibernateJsf.service;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.springHibernateJsf.dao.EmployeeDao;
import com.sample.springHibernateJsf.entity.Employee;

@Service
@ManagedBean (name="employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	private Employee employee;
	
	@Transactional
	public List<Employee> getEmployees(){
		List<Employee> employeeList = employeeDao.getEmployees();
		
		return employeeList;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Transactional
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public void deleteEmployee(Long Id){
		employeeDao.deleteEmployee(Id);

	}
	
	@Transactional
	public int updateEmployee(Employee employee){
		int val = employeeDao.updateEmployee(employee);
		return val;
	}
	
	
	public String editAction(Employee employee){
		employee.setEditable(true);
		return null;
	}
	
	public String saveAction(){
		employee.setEditable(false);
		return null;
	}
}
