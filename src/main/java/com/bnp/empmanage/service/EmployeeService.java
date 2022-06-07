package com.bnp.empmanage.service;

import com.bnp.empmanage.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(String uid);

    public List<Employee> findByStatus(int status);

    public void save(Employee theEmployee);

    public void deleteById(String uid);
}
