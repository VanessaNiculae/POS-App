/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.proiectlab.bean;

import com.proiectlab.entity.Product;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProductBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void createProduct(String productName, Double price, String unit, int quantity) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Product productToAdd = new Product();
        productToAdd.setProductName(productName);
        productToAdd.setPrice(price);
        productToAdd.setUnit(unit);
        productToAdd.setQuantity(quantity);

        entityManager.persist(productToAdd);
    }

    public List<Product> getAllProducts() {
        try {
            TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Product findById(Integer productId) {
        Product product = entityManager.find(Product.class, productId);
        return product;
    }

    public Product findByName(String productName) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findByProductName", Product.class);
        query.setParameter("productName", productName);
        Product result = query.getSingleResult();

        return result;
    }

    public void updateProduct(Product product, String newProductName, Double newPrice, String newUnit, int newQuantity) {

        if (!entityManager.contains(product)) {
            product = entityManager.merge(product);
        }
        if (newProductName != null) {
            product.setProductName(newProductName);
        }
        if (newPrice != null) {
            product.setPrice(newPrice);
        }
        if (newUnit != null) {
            product.setUnit(newUnit);
        }
        if (newQuantity != 0) {
            product.setQuantity(newQuantity);
        }
    }

    public void deleteProduct(Product product) {
        if (!entityManager.contains(product)) {
            product = entityManager.merge(product);
        }
        entityManager.remove(product);
    }

}
