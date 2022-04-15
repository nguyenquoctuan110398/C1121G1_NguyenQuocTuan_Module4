package com.example.dto;

public class BlogDto {
    private Integer id;

    private String author;
    private String image;
    private String date;
    private String content;
    private String summary;
    private CategoryDto categoryDto;

    public BlogDto() {
    }

    public BlogDto(String author, String image, String date, String content,
                   String summary, CategoryDto categoryDto) {
        this.author = author;
        this.image = image;
        this.date = date;
        this.content = content;
        this.summary = summary;
        this.categoryDto = categoryDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
