package com.nareksarkisyan.spring.mvc_hibernate_aop.controller;

import com.nareksarkisyan.spring.mvc_hibernate_aop.entity.Employee;
import com.nareksarkisyan.spring.mvc_hibernate_aop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
//TODO: неее, тут все пока плохо
//1 - надо через @RestController и @GetMapping, @PostMapping, @DeleteMapping и тд сделать.
//2 - у тебя все операции через GET делаются, это отвратительно, почитай про методы HTTP, зачем какой используется
//т.е. у тебя DELETE - для удаления должно быть, POST - для создания и тд
// не расстраивайся, просто надо Вь*бывать, а ты халявишь, я прям 100% даю что ты пару часов только в день этим занимаешься
// :)))
public class MyController {

    private final EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/deleteInfo")
    public String deleteEmployee(@RequestParam("empId") int id){
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);

        return "redirect:/";
    }
}
