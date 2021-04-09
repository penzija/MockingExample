package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        initEmployees();
    }

    private void initEmployees() {
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
        e.setId("emp5");
        e.setSalary(5);
        return e;
    }
}
