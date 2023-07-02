package com.bitee.entities;

public interface Cart {
    boolean isEmpty();
    void addProduct(Product productId);
    Product[] getProducts();
    void clear();

}
