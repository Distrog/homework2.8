package ru.stroganov.skypro.employee_map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.skypro.employee_map.model.Employee;
import ru.stroganov.skypro.employee_map.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") Integer department,
                        @RequestParam("salary") Integer salary) {
        return employeeService.add(firstName, lastName,department,salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") Integer department,
                           @RequestParam("salary") Integer salary) {
        return employeeService.remove(firstName, lastName,department,salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") Integer department,
                         @RequestParam("salary") Integer salary) {
        return employeeService.find(firstName, lastName,department,salary);
    }

    @GetMapping("/info")
    public List<Employee> info() {
        return employeeService.getInfo();
    }
}
