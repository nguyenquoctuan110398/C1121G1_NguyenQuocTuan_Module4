package com.example.repository.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e " +
            "where e.deleteFlag = true and e.employeeName like concat('%', :keyWord, '%')")
    Page<Employee> findAll(String keyWord, Pageable pageable);

    @Query("select e from Employee e where e.deleteFlag = true")
    List<Employee> findAllList();
}
