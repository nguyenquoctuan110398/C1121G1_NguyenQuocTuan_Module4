package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();

        products.put(1, new Product(1, "Coca", 10000.0, "Chai", "Cocacola"));
        products.put(2, new Product(2, "7up", 10000.0, "Lon", "ABC"));
        products.put(3, new Product(3, "Aquafina", 5000.0, "Chai", "ABC"));
        products.put(4, new Product(4, "Fanta", 10000.0, "Chai", "ABC"));
        products.put(5, new Product(5, "Sting dâu", 10000.0, "Chai", "Sting"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByID(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>(products.values());
        List<Product> productAfterSearchList = new ArrayList<>();
        for (Product product:productList) {
            if (product.getName().contains(name)){
                productAfterSearchList.add(product);
            }
        }
        return productAfterSearchList;
    }
}
