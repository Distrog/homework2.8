package ru.stroganov.skypro.employee_map.service;

import org.springframework.stereotype.Service;
import ru.stroganov.skypro.employee_map.model.Employee;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {
    EmployeeService employeeService;

    public DepartmentServiceImp(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(e -> e.getSalary())).get();
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> department == department)
                .min(Comparator.comparing(e -> e.getSalary())).get();
    }

    @Override
    public List<Employee> getAllEmployeesFromDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesFromAllDepartments() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
