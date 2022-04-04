package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findByID(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        iProductRepository.update(id, product);

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.remove(id);
    }
}
