package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(String author, Pageable pageable) {
        return iBlogRepository.findAllByAuthorContainingOrderByDate(author, pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByCategory(Integer id, Pageable pageable) {
        return iBlogRepository.findAllByCategoryIdOrderByDate(id, pageable);
    }

    @Override
    public List<Blog> findAllList(String searchAuthor) {
        return iBlogRepository.findAllByAuthorContainingOrderByDate(searchAuthor);
    }

//    @Override
//    public List<Blog> searchByNameAuthor(String author) {
//        return iBlogRepository.findByAuthorContaining(author);
//    }
}
