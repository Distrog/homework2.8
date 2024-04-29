package ru.stroganov.skypro.employee_map.service;

import org.springframework.stereotype.Service;
import ru.stroganov.skypro.employee_map.exception.DepartmentNotFoundException;
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
    public List<Employee> getAllEmployeesFromDepartment(int departmentId) {
        if (employeeService.getEmployees().values().stream().mapToInt(e -> e.getDepartment()).noneMatch(e -> e == departmentId)) {
            throw new DepartmentNotFoundException();
        }
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getSumOfSalariesFromDepartment(int departmentId) {
        if (employeeService.getEmployees().values().stream().mapToInt(e -> e.getDepartment()).noneMatch(e -> e == departmentId)) {
            throw new DepartmentNotFoundException();
        }
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId).
                mapToInt(e -> e.getSalary()).sum();
    }

    @Override
    public Integer getMaxSalaryFromDepartment(int departmentId) {
        if (employeeService.getEmployees().values().stream().mapToInt(e -> e.getDepartment()).noneMatch(e -> e == departmentId)) {
            throw new DepartmentNotFoundException();
        }
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToInt(e -> e.getSalary()).max().getAsInt();
    }

    @Override
    public Integer getMinSalaryFromDepartment(int departmentId) {
        if (employeeService.getEmployees().values().stream().mapToInt(e -> e.getDepartment()).noneMatch(e -> e == departmentId)) {
            throw new DepartmentNotFoundException();
        }
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToInt(e -> e.getSalary()).min().getAsInt();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesFromAllDepartments() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
