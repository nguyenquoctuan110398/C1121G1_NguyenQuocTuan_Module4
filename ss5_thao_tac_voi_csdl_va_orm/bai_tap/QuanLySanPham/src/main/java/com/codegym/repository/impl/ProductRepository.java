package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        if (product.getId() == null) {
            BaseRepository.entityManager.persist(product);
        }
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery
                        ("select p " +
                                "from Product p " +
                                "where p.id= :productId", Product.class);
        typedQuery.setParameter("productId", id);

        return typedQuery.getSingleResult();
    }

    @Override
    public void update(Integer id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        if (product.getId() == id) {
            BaseRepository.entityManager.merge(product);
        }
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        BaseRepository.entityManager.remove(findById(id));

        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : this.findAll()) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }

        return productList;
    }
}
