package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findByID(Integer id);

    void update(Integer id, Product product);

    void delete(Integer id);

    List<Product> searchByName(String name);
}
