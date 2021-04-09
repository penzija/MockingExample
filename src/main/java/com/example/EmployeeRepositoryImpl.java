package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("emp1", 1.0));
        employees.add(new Employee("emp2", 2.0));
        employees.add(new Employee("emp3", 3.0));
        employees.add(new Employee("emp4", 4.0));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        e.setId("id value modified in the method");
        e.setSalary(100);
        return e;
    }
}
