package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(String keyWord,Pageable pageable);

    void save(Employee employee);

    Employee findById(Integer employeeId);
}
