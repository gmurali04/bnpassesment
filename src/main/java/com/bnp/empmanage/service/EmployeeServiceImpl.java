package com.bnp.empmanage.service;

import com.bnp.empmanage.dao.EmployeeRepo;
import com.bnp.empmanage.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepo.findAll();
        if(employees.isEmpty())
            throw new RuntimeException("Database is Empty");
        else
            return employees;
    }

    @Override
    public Employee findById(String uid) {
        Optional<Employee> employee = employeeRepo.findById(uid);
        if (employee.isPresent())
            return employee.get();
        else
            throw new RuntimeException("Employee with uid "+employee.get().getUid());
    }

    @Override
    public List<Employee> findByStatus(int status) {
        List<Employee> employees = employeeRepo.findByStatus(status);
        if (employees.isEmpty()&&status==2)
            throw new RuntimeException("No Active Employees Found");
        else if (employees.isEmpty()&&status==1)
            throw new RuntimeException("No Inactive Employees Found");
        else if (employees.isEmpty())
            throw new RuntimeException("Database is Empty");
        else
            return employees;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(String uid) {
        Optional<Employee> employee = employeeRepo.findById(uid);
        if (employee.isPresent())
            employeeRepo.deleteById(uid);
        else
            throw new RuntimeException("Employee with uid "+uid+" not found");
    }
}
