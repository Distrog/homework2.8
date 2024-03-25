package ru.stroganov.skypro.employee_map.service;


import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface EmployeeService {
    public Map<String, Employee> getEmployees();
    Employee add(String firstName, String lastName,int department,int salary);
    Employee remove(String firstName, String lastName,int department,int salary);
    Employee find(String firstName, String lastName,int department,int salary);
    List<Employee> getInfo();
}
