package ru.stroganov.skypro.employee_map.service;

import org.springframework.stereotype.Service;
import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {
    Map<String, Employee> employees;

    public DepartmentServiceImp(EmployeeService employeeService) {
        this.employees = employeeService.getEmployees();
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(e -> e.getSalary())).get();
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values().stream()
                .filter(e -> department == department)
                .min(Comparator.comparing(e -> e.getSalary())).get();
    }

    @Override
    public List<Employee> getAllEmployeesFromDepartment(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeesFromAllDepartments() {
        return employees.values().stream()
                .sorted(Comparator.comparing(e -> e.getDepartment()))
                .collect(Collectors.toList());
    }
}
