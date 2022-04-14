package com.example.dto;

import java.util.List;

public class CategoryDto {

    private Integer id;
    private String name;
    private List<BlogDto> blogDtos;

    public CategoryDto() {
    }

    public CategoryDto(String name, List<BlogDto> blogDtos) {
        this.name = name;
        this.blogDtos = blogDtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogDto> getBlogDtos() {
        return blogDtos;
    }

    public void setBlogDtos(List<BlogDto> blogDtos) {
        this.blogDtos = blogDtos;
    }
}
