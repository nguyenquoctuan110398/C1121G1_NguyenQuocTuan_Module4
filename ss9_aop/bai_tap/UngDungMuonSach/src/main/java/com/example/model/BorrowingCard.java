package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class BorrowingCard {
    @Id
    private Integer id;

    @Column(columnDefinition = "date")
    private String startDay;

    @Column(columnDefinition = "date")
    private String endDay;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowingCard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
