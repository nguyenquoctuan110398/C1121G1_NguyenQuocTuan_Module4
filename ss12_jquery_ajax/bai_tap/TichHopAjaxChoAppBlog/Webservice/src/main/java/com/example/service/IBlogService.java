package com.example.service;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String author ,Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    Page<Blog> findAllByCategory(Integer id, Pageable pageable);

    List<Blog> findAllList(String searchAuthor);

//    List<Blog> searchByNameAuthor(String author);
}
