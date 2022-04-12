package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookDto {

    @NotBlank
    @Pattern(regexp = "^(B)-[0-9]{4}$")
    private String id;

    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$")
    private String name;

    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$")
    private String author;

    @NotNull
    private Integer quantity;

    public BookDto() {
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
