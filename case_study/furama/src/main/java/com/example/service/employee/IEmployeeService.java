package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(String keyWord,Pageable pageable);

    void save(Employee employee);

    Employee findById(Integer employeeId);

    List<Employee> findAllList();
}
