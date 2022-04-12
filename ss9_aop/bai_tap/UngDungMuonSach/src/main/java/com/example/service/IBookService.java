package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(String id);

    void reduceQuatityBook(Book book);

    void returnBook(Book book);
}
