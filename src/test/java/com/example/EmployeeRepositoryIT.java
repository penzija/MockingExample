package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;


public class EmployeeRepositoryIT {


    Employee newValue = new Employee("2", 22000);

    @Test
    void integrationTest1_CheckFindAllMethod() {
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        List<Employee> employeeList = employeeRepository.findAll();
        Employee containedValue = employeeList.get(0);

        assertThat(containedValue.getId()).isEqualTo("test");
    }

    @Test
    void integrationTest2_checkSaveMethod() {
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        Employee expectedValue = new Employee("this text will disappear", 10);

        assertThat(employeeRepository.save(expectedValue).getId()).isEqualTo("id value modified in the method");
    }
}
