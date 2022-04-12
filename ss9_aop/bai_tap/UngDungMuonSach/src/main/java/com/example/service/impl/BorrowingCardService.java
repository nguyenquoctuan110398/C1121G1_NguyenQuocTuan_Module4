package com.example.service.impl;

import com.example.model.Book;
import com.example.model.BorrowingCard;
import com.example.repository.IBorrowingCardRepository;
import com.example.service.IBorrowingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingCardService implements IBorrowingCardService {

    @Autowired
    private IBorrowingCardRepository iBorrowingCardRepository;

    @Override
    public void save(BorrowingCard borrowingCard) {
        iBorrowingCardRepository.save(borrowingCard);
    }

    @Override
    public List<BorrowingCard> findAll() {
        return iBorrowingCardRepository.findAll();
    }

    @Override
    public BorrowingCard findById(Integer borrowingCardId) {
        return iBorrowingCardRepository.findById(borrowingCardId).orElse(null);
    }

    @Override
    public void delete(Integer borrowingCardId) {
        iBorrowingCardRepository.deleteById(borrowingCardId);
    }
}
