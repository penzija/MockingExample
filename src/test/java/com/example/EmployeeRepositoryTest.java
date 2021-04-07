package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {
    private final EmployeeRepository employeeRepository = new EmployeeRepositoryIT();

    @Test
    public void findAll() {
        List<Employee> employees = employeeRepository.findAll();

        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee("emp1", 1.0));
        expected.add(new Employee("emp2", 2.0));
        expected.add(new Employee("emp3", 3.0));
        expected.add(new Employee("emp4", 4.0));

        assertIterableEquals(expected, employees);
    }

    @Test
    public void save() {
        Employee employee = new Employee("emp1", 2.0);
        Employee actual = employeeRepository.save(employee);
        assertEquals(employee, actual);
    }
}
