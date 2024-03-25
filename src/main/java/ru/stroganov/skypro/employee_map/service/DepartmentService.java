package ru.stroganov.skypro.employee_map.service;

import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.List;

public interface DepartmentService {
    public Employee getEmployeeWithMaxSalary(int department);
    public Employee getEmployeeWithMinSalary(int department);
    public List<Employee> getAllEmployeesFromDepartment(int department);
    public List<Employee> getAllEmployeesFromAllDepartments();
}
