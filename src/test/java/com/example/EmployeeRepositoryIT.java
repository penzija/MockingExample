package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class EmployeeRepositoryIT {

    @Test
    void integrationTest1_CheckFindAllMethod() {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

        Employee insertedValueInSaveMethod = new Employee("test object", 10);
        employeeRepository.save(insertedValueInSaveMethod);
        Employee notInsertedValueInSaveMethod = new Employee("test object2", 20);

        List<Employee> employeeList = employeeRepository.findAll();

        assertThat(employeeList.isEmpty()).isFalse();
        assertThat(employeeList.contains(notInsertedValueInSaveMethod)).isFalse();
        assertThat(employeeList.contains(insertedValueInSaveMethod)).isTrue();
    }

    @Test
    void integrationTest2_checkSaveMethod() {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

        Employee insertedValue = new Employee("test object", 10);
        Employee expectedValue = employeeRepository.save(insertedValue);
        Employee wrongValue = new Employee("test object2", 10);
        List<Employee> employeeList = employeeRepository.findAll();

        assertThat(employeeList.contains(wrongValue)).isFalse();
        assertThat(employeeList.contains(expectedValue)).isTrue();
    }

    @Test
    void integrationTest3_checkEmployeeManager_payEmployeesMethod() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        BankService bankService = new BankServiceImpl();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        employeeRepository.save(new Employee("test", 10));

        int actual = employeeManager.payEmployees();

        assertEquals(1, actual);
    }
}
