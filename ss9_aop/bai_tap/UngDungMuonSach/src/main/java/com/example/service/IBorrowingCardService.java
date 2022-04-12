package com.example.service;

import com.example.model.Book;
import com.example.model.BorrowingCard;

import java.util.List;

public interface IBorrowingCardService {
    void save(BorrowingCard borrowingCard);

    List<BorrowingCard> findAll();

    BorrowingCard findById(Integer borrowingCardId);

    void delete(Integer borrowingCardId);
}
