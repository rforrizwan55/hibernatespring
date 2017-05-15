package hibernateExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hibernateExample.model.Employee;
import hibernateExample.model.EmployeeList;
import hibernateExample.service.EmployeeService;

@Controller
public class HBController {
	
	@Autowired
	private EmployeeService empService;

	
	@RequestMapping(value="/add" , method= RequestMethod.GET)
	public ModelAndView Login(){
		List<Employee> empList;
		ModelAndView mav = new ModelAndView("Welcome");
		empList = empService.getAllEmployees();
		mav.addObject("empList",  empList);
		
		return mav;
	}
	
	
	
	@RequestMapping(value="/add" , method= RequestMethod.POST)
	public ModelAndView LoginSubmission(@ModelAttribute("emp") Employee emp , @RequestParam String action){
		String msg = null;
		Employee empObj = null ;
		List<Employee> empList;
		ModelAndView mav = new ModelAndView("Welcome");
		switch (action.toLowerCase()) {
		case "add":
			empService.addEmployee(emp);
			msg = emp.getLastName() + " has been added";
			break;
		case "edit":
			empService.updateEmployee(emp);
			msg = emp.getLastName() + " has been updated";
			break;
		case "search":
			empObj = empService.getEmployee(emp.getEmpId());
			mav.addObject("eid",  empObj.getEmpId());
			mav.addObject("fname",  empObj.getFirstName());
			mav.addObject("lname",  empObj.getLastName());
			msg = empObj.getLastName() + " has been searched";
			break;
		case "delete":
			empService.deleteEmployee(emp);
			msg = emp.getLastName() + " has been deleted";
			break;
		
		default:
			break;
		}
		
		empList = empService.getAllEmployees();
		mav.addObject("msg", msg);
		mav.addObject("empList",  empList);
		
		return mav;
	}

}
