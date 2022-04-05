package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
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
    public void like(Blog blog) {
       blog.setCountLike(blog.getCountLike()+1);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

//    @Override
//    public List<Blog> searchByNameAuthor(String author) {
//        return iBlogRepository.findByAuthorContaining(author);
//    }
}
