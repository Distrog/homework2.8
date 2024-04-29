package ru.stroganov.skypro.employee_map.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.stroganov.skypro.employee_map.exception.DepartmentNotFoundException;
import ru.stroganov.skypro.employee_map.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImpTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImp departmentService;
    Map<String,Employee> employees;
    @BeforeEach
    public void createEmployees(){
        employees = new HashMap<>();
        employees.put( "Ivan Ivanov", new Employee("Ivan", "Ivanov", 1, 1000));
        employees.put("Petr Petrov", new Employee("Petr", "Petrov", 1, 2000));
        employees.put("Oleg Olegov", new Employee("Oleg", "Olegov", 1, 3000));
        employees.put("Mitya Mityaev", new Employee("Mitya", "Mityaev", 2, 4000));
        employees.put("Bruce Willias", new Employee("Bruce", "Willias", 2, 5000));
        employees.put("Jack Sparrow", new Employee("Jack", "Sparrow", 2, 6000));
        employees.put("Dmitriy Dmitriev", new Employee("Dmitriy", "Dmitriev", 3, 7000));
        employees.put("Tom Hardy", new Employee("Tom", "Hardy", 3, 8000));
        employees.put("Kesha Pipkin", new Employee("Kesha", "Pipkin", 3, 9000));
    }
    @Test
    public void getSumNormal() {
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertEquals(departmentService.getSumOfSalariesFromDepartment(1),6000);
    }
    @Test
    public void sumWithNotFoundDepartment(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertThrows(DepartmentNotFoundException.class,
                ()->departmentService.getSumOfSalariesFromDepartment(4));
    }
    @Test
    public void getMinSalaryFromDepartmentNormal(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertEquals(departmentService.getMinSalaryFromDepartment(1),1000);
    }

    @Test
    public void getMinSalaryFromNotFoundDepartment(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertThrows(DepartmentNotFoundException.class,
                ()->departmentService.getMinSalaryFromDepartment(4));
    }
    @Test
    public void getMaxSalaryFromDepartmentNormal(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertEquals(departmentService.getMaxSalaryFromDepartment(1),3000);
    }

    @Test
    public void getMaxSalaryFromNotFoundDepartment(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertThrows(DepartmentNotFoundException.class,
                ()->departmentService.getMaxSalaryFromDepartment(4));
    }

    @Test
    public void getAllEmployeesFromDepartment3(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertEquals(departmentService.getAllEmployeesFromDepartment(3),new ArrayList<>(List.of(
                new Employee("Dmitriy", "Dmitriev", 3, 7000),
                new Employee("Tom", "Hardy", 3, 8000),
                new Employee("Kesha", "Pipkin", 3, 9000)
        )));
    }

    @Test
    public void getAllEmployeesFromNotFoundDepartment(){
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        assertThrows(DepartmentNotFoundException.class,
                ()->departmentService.getAllEmployeesFromDepartment(4));
    }
}