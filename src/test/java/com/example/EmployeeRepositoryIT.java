package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
}
