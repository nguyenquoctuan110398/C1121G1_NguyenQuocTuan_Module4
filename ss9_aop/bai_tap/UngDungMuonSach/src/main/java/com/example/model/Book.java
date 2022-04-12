package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    private String id;

    private String name;

    private String author;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<BorrowingCard> borrowingCards;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
