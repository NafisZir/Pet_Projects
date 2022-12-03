package ru.kai.vvpi.realEstateAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.vvpi.realEstateAgency.models.Employee;
import ru.kai.vvpi.realEstateAgency.services.DealService;
import ru.kai.vvpi.realEstateAgency.services.EmployeeService;
import ru.kai.vvpi.realEstateAgency.services.FlatService;


@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final FlatService flatService;
    private final DealService dealService;

    public EmployeeController(EmployeeService employeeService, FlatService flatService, DealService dealService) {
        this.employeeService = employeeService;
        this.flatService = flatService;
        this.dealService = dealService;
    }

    @GetMapping("/employee")
    public String employee(Model model){
        model.addAttribute("employee_id", employeeService.getWho());
        model.addAttribute("flats", flatService.getFlatList());
        return "employee";
    }

    @GetMapping("/employee/login")
    public String employeeLogin(){
        return "employeeLogin";
    }

    @PostMapping("/employee/check")
    public String employee(Employee employee, Model model){
        if(employeeService.isTrue(employee.getPassword())){
            employeeService.setWho(employee.getPassword());
            return "redirect:/employee";
        }
        return "redirect:/main";
    }
}
