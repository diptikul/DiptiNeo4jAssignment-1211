package com.neo4j.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final  EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping(value="/")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createEmployee(Model model, @ModelAttribute Employee employee) {
        Employee employee1 = employeeService.createEmployee(employee);
        return "redirect:/employees/";
    }

    @GetMapping(value="/getEmployee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
