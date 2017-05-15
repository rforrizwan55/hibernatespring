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
		
		List<Employee> empList;
		ModelAndView mav = new ModelAndView("Welcome");
		switch (action.toLowerCase()) {
		case "add":
			empService.addEmployee(emp);
			break;
		case "edit":
			empService.updateEmployee(emp);
			break;
		case "delete":
			empService.deleteEmployee(emp);
			break;
		
		default:
			break;
		}
		
		empList = empService.getAllEmployees();
		mav.addObject("msg", emp.getLastName() + " has been created.");
		mav.addObject("empList",  empList);
		
		return mav;
	}

}
