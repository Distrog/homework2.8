package ru.stroganov.skypro.employee_map.controller;

import org.springframework.web.bind.annotation.*;
import ru.stroganov.skypro.employee_map.model.Employee;
import ru.stroganov.skypro.employee_map.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesFromDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getAllEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSumOfSalariesFromDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getSumOfSalariesFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public Integer getMaxSalaryFromDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Integer getMinSalaryFromDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getMinSalaryFromDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesFromAllDepartments() {
        return departmentService.getAllEmployeesFromAllDepartments();

    }

}
