package ru.stroganov.skypro.employee_map.service;

import org.junit.jupiter.api.Test;
import ru.stroganov.skypro.employee_map.exception.EmployeeAlreadyAddedException;
import ru.stroganov.skypro.employee_map.exception.EmployeeNotFoundException;
import ru.stroganov.skypro.employee_map.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImpTest {

    EmployeeService employeeService = new EmployeeServiceImp();
    @Test
    public void addNewEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1000);
        assertTrue(employeeService.getEmployees().containsKey("Ivan Ivanov"));
    }

    @Test
    public void addAlreadyAddedEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1000);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService
                        .add("Ivan", "Ivanov", 1, 1000));
    }

    @Test
    public void findEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1000);
        assertEquals(employeeService.find("Ivan", "Ivanov", 1, 1000),
                new Employee("Ivan", "Ivanov", 1, 1000));
    }

    @Test
    public void findNullEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find("Ivan", "Ivanov", 1, 1000));
    }

    @Test
    public void removeEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1000);
        assertEquals(employeeService.remove("Ivan", "Ivanov", 1, 1000),
                new Employee("Ivan", "Ivanov", 1, 1000));
    }

    @Test
    public void removeNullEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove("Ivan", "Ivanov", 1, 1000));
    }
}