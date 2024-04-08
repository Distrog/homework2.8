package ru.stroganov.skypro.employee_map.service;

import org.springframework.stereotype.Service;
import ru.stroganov.skypro.employee_map.exception.EmployeeAlreadyAddedException;
import ru.stroganov.skypro.employee_map.exception.EmployeeNotFoundException;
import ru.stroganov.skypro.employee_map.exception.EmployeeStorageIsFullException;
import ru.stroganov.skypro.employee_map.model.Employee;
import ru.stroganov.skypro.employee_map.string_checker.StringChecker;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private Map<String, Employee> employees;
    int count;

    public EmployeeServiceImp() {
        this.employees = new HashMap<>();
        count = 100;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        firstName = StringChecker.check(firstName);
        lastName = StringChecker.check(lastName);
        if (employees.size() > count) {
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        }
        if (employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник " +
                    "уже имеется в коллекции");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.put(firstName + " " + lastName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, int salary) {
        if (!employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.remove(firstName + " " + lastName, employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, int salary) {
        if (!employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employee;
    }

    @Override
    public List<Employee> getInfo() {
        return new ArrayList<>(employees.values());
    }
}
