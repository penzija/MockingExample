package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class EmployeeRepository2IT {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Test

    public void findAllTest() {
        List<Employee> employeeList = employeeRepository.findAll();
        Employee actual = employeeList.get(1);

        assertThat(actual.getId()).isEqualTo("emp2");

    }

    @Test
    public void saveTest() {
        Employee expectedValue = new Employee("emp6", 10);

        assertThat(employeeRepository.save(expectedValue).getId()).isEqualTo("emp5");
    }
}
