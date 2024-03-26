package ru.stroganov.skypro.employee_map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.skypro.employee_map.model.Employee;
import ru.stroganov.skypro.employee_map.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesFromAllDepartments() {
        return departmentService.getAllEmployeesFromAllDepartments();

    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllEmployeesFromDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return departmentService.getAllEmployeesFromDepartment(departmentId);
    }
}
