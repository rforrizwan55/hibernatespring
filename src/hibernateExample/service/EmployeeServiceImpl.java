package hibernateExample.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernateExample.DAO.EmployeeDAO;
import hibernateExample.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;
	@Transactional
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.addEmployee(emp);

	}

	@Transactional
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.updateEmployee(emp);
	}

	@Transactional
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.deleteEmployee(emp);
	}

	@Transactional
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return empDAO.getEmployee(empId);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDAO.getAllEmployees();
	}

}
