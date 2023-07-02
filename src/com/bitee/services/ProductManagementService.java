package com.bitee.services;

import com.bitee.entities.Product;

public interface ProductManagementService {
    Product[] getProducts();

    Product getProductById(int productIdAddToCart);
}
