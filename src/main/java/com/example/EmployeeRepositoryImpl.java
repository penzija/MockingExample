package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("test", 0));
        employees.add(new Employee("luka", 15000));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        e.setId("id value modified in the method");
        e.setSalary(100);
        return e;
    }
}
