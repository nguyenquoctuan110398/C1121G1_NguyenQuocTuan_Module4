package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c " +
            "where c.deleteFlag=true and c.customerName like concat('%', :name, '%')")
    Page<Customer> findAll(@Param("name") String keyWord, Pageable pageable);
}
