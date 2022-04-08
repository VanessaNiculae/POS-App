package com.proiectlab.patterns;

import com.proiectlab.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productsInCart = null;
    private static Cart cart = null;

    private CartType cartType = null;

    public static Cart getInstance() {

        if (cart == null) {
            cart = new Cart();
        }

        return cart;
    }

    private Cart() {
        productsInCart = new ArrayList<>();
    }

    public CartType getCartType() {
        return cartType;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setCartType(CartType cartType) {
        this.cartType = cartType;
    }

    public void addProductToCart(Product product) {
        productsInCart.add(product);
    }

    public double calculateValueOfCart() {
        return productsInCart.stream().mapToDouble(p -> p.getPrice()).sum();
    }

public void prepareForNewAction(){
   productsInCart.clear();
   setCartType(null);
 }

}
