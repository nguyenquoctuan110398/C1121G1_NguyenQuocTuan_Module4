package com.example.repository;

import com.example.model.BorrowingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowingCardRepository extends JpaRepository<BorrowingCard, Integer> {
}
