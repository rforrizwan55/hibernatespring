package hibernateExample.service;

import java.util.List;

import hibernateExample.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployees();
}
