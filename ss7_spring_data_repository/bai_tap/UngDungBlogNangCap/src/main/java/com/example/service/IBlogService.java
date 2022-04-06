package com.example.service;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(String author ,Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void like(Blog blog);

    void delete(Integer id);

    Page<Blog> findAllByCategory(Integer id, Pageable pageable);

//    List<Blog> searchByNameAuthor(String author);
}
