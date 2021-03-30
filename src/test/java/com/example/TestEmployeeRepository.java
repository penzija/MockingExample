package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("test", 1.0), new Employee("test2", 2.0));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
