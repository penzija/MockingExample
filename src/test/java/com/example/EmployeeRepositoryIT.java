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

        assertThat(containedValue.getId()).isEqualTo("emp1");
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

        assertEquals(4, actual);
    }
}
