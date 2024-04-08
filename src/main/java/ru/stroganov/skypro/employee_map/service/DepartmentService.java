package ru.stroganov.skypro.employee_map.service;

import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee getEmployeeWithMaxSalary(int department);
    public Employee getEmployeeWithMinSalary(int department);
    public List<Employee> getAllEmployeesFromDepartment(int department);
    public Map<Integer,List<Employee>> getAllEmployeesFromAllDepartments();
}
