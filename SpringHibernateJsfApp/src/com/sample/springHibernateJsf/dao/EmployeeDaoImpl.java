package com.sample.springHibernateJsf.dao;

import java.util.List;


import com.sample.springHibernateJsf.entity.Employee;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;  
	
    
	@Override
	public List<Employee> getEmployees(){
		logger.info("in EmployeeDaoImpl getEmployees");
		Session session = this.sessionFactory.getCurrentSession();
		List <Employee> employeeList = session.createQuery("from Employee").list();
	      return employeeList;
	}
	
	@Override
	public void addEmployee(Employee employee)  {
		 logger.info("in EmployeeDaoImpl addEmployee ");
		 Session session = this.sessionFactory.getCurrentSession();
		 session.save(employee);
		 employee = null;
	}
	
	@Override
	public void deleteEmployee(Long Id)  {
		 logger.info("in EmployeeDaoImpl deleteEmployee ");
		 Session session = this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("delete from Employee e where e.Id ="+Id+"");
		 query.executeUpdate();
		}
	
	@Override
	public int updateEmployee(Employee employee)  {
		 logger.info("in EmployeeDaoImpl updateEmployee ");
		 Session session = this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("update Employee set firstname='"+employee.getfName()+"', lastname='"+employee.getlName()+"', email = '"+employee.getEmail()+"' where Id ="+employee.getId()+"");
		 int val = query.executeUpdate();
		 return val; 
	}
	

}
