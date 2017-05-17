package hibernateExample.restapicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hibernateExample.model.Employee;
import hibernateExample.service.EmployeeService;

@RestController
public class EmployeeRestApiControllers {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/employees" , method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	//@RequestMapping(value="/employees" , method= RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public List<Employee> getEmployees(){
		return  empService.getAllEmployees();
	}
	
	@RequestMapping(value="/employees/{empId}" , method= RequestMethod.GET)
	public Employee getEmployeesById(@PathVariable("empId") int empId ){
		return  empService.getEmployee(empId);
	}
	
	@RequestMapping(value="/employees/{empId}" , method= RequestMethod.PUT)
	public boolean updateEmployeesById(@PathVariable("empId") int empId ,@RequestBody Employee emp){
		empService.updateEmployee(emp);
		
		return true;
	}
	
	@RequestMapping(value="/employees" , method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addEmployees(@RequestBody Employee emp){
		empService.addEmployee(emp);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

}
