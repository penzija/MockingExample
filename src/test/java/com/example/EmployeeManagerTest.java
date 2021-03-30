package com.example;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeManagerTest {

    @Test
    void checkIf_PayAllMethod_IsFillingCorrectly() {

        EmployeeRepository employeeRepository = new TestEmployeeRepository();
        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertEquals(2, actual);
    }

}