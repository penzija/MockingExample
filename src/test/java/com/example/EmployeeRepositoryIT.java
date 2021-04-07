package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryIT implements EmployeeRepository {

    private static  List<Employee> employees = new ArrayList<>();

    static {
        populateEmployees();
    }

    private static void populateEmployees() {
        employees.add(new Employee("emp1", 1.0));
        employees.add(new Employee("emp2", 2.0));
        employees.add(new Employee("emp3", 3.0));
        employees.add(new Employee("emp4", 4.0));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        for (Employee employee : employees) {
            if (employee.getId().equals(e.getId())) {
                employee.setSalary(employee.getSalary());
            }
        }
        return e;
    }
}
