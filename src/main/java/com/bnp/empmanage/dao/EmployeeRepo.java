package com.bnp.empmanage.dao;

import com.bnp.empmanage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    public List<Employee> findByStatus(int status);
}
