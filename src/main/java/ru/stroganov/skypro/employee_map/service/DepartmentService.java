package ru.stroganov.skypro.employee_map.service;

import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllEmployeesFromDepartment(int department);
    public Integer getSumOfSalariesFromDepartment(int departmentId);
    public Integer getMaxSalaryFromDepartment(int department);
    public Integer getMinSalaryFromDepartment(int department);
    public Map<Integer,List<Employee>> getAllEmployeesFromAllDepartments();
}
