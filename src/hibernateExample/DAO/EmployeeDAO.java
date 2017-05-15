package hibernateExample.DAO;

import java.util.List;

import hibernateExample.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployees();
}
