package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeManagerIT  {

    @Test
    void checkIf_PayAllMethod_IsFillingCorrectly() {

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        BankService bankService = new BankServiceStub();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int actual = employeeManager.payEmployees();

        assertEquals(4, actual);
    }
}
