package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void reduceQuatityBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }
}
