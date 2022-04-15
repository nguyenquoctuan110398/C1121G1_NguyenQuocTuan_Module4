package com.example.repository;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByAuthorContainingOrderByDate(String author, Pageable pageable);

    List<Blog> findAllByAuthorContainingOrderByDate(String author);

    Page<Blog> findAllByCategoryIdOrderByDate(Integer id, Pageable pageable);
}
