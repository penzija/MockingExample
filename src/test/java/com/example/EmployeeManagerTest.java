package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {

    @Test
    void checkIf_PayAllMethod_IsFillingCorrectly() {

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        BankService bankService = new BankServiceImpl();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        employeeRepository.save(new Employee("test", 10));
        employeeRepository.save(new Employee("test2", 20));

        int actual = employeeManager.payEmployees();

        assertEquals(2, actual);
    }

    @Test
    void checkIf_PayAllMethod_IsFillingCorrectly_withMockito() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll())
                .thenReturn(List.of(new Employee("test", 1.0), new Employee("test2", 2.0)));
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int actual = employeeManager.payEmployees();

        assertEquals(2, actual);
    }
}