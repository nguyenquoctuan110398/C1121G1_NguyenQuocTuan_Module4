package com.example.repository;

import com.example.model.employee.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
