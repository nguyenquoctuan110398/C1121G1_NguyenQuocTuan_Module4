package com.example.repository;

import com.example.model.SoTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {
}
