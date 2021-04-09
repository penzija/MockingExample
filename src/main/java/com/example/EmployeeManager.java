package com.example;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeManager {

    private final EmployeeRepository employeeRepository;
    private final BankService bankService;

    public EmployeeManager(EmployeeRepository employeeRepository, BankService bankService) {
        this.employeeRepository = employeeRepository;
        this.bankService = bankService;
    }

    public int payEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        int payments = 0;
        for (Employee employee : employees) {
            try {
                bankService.pay(employee.getId(), employee.getSalary());
                employee.setPaid(true);
                payments++;
            } catch (RuntimeException e) {
                employee.setPaid(false);
            }
        }
        return payments;
    }

//    public static void main(String[] args) {
//        LinkedList mockedList = mock(LinkedList.class);
//        when(mockedList.get(0)).thenReturn("This list does not really exist");
//        System.out.println(mockedList.get(0));
//    }
}
