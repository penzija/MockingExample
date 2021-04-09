package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class EmployeeRepositoryIT {

    @Test
    void integrationTest1_CheckFindAllMethod() {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        List<Employee> employeeList = employeeRepository.findAll();
        Employee containedValue = employeeList.get(0);

        assertThat(containedValue.getId()).isEqualTo("test");
    }

    @Test
    void integrationTest2_checkSaveMethod() {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        Employee expectedValue = new Employee("this text will disappear", 10);

        assertThat(employeeRepository.save(expectedValue).getId()).isEqualTo("id value modified in the method");
    }

    @Test
    void integrationTest3_checkEmployeeManager_payEmployeesMethod() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        BankService bankService = new BankServiceImpl();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int actual = employeeManager.payEmployees();

        assertEquals(3, actual);
    }

    @Test
    public void findAll() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
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
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        Employee employee = new Employee("emp1", 2.0);
        Employee actual = employeeRepository.save(employee);
        assertEquals(employee, actual);
    }
}
