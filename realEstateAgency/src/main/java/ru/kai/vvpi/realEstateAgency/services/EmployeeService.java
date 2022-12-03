package ru.kai.vvpi.realEstateAgency.services;

import org.springframework.stereotype.Service;
import ru.kai.vvpi.realEstateAgency.models.Employee;
import ru.kai.vvpi.realEstateAgency.repositories.EmployeeRepository;


import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private String who;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public boolean isTrue(String password){
        return employeeRepository.findByPassword(password) != null;
    }

    public String getEmployeeName(String id){
        Employee employee = employeeRepository.findByPassword(id);
        return employee.getName();
    }
}
