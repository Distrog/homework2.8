package ru.stroganov.skypro.employee_map.service;


import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.Collection;
import java.util.List;


public interface EmployeeService {
    Employee add(String firstName,String lastName);
    Employee remove(String firstName,String lastName);
    Employee find(String firstName,String lastName);
    List<Employee> getInfo();
}
