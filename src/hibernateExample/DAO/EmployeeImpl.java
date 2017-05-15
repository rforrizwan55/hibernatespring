package hibernateExample.DAO;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernateExample.model.Employee;

@Repository
public class EmployeeImpl implements EmployeeDAO{
	
	@Autowired
	private SessionFactory session;

	@Transactional
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(emp);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(emp); 
		
	}

	@Override
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return (Employee)session.getCurrentSession().get(Employee.class, empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return session.getCurrentSession().createQuery("from Employee").list(); 
		 
	}
	
	

}
