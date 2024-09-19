package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.Products;
import com.example.webservicecangpt.entities.PurchaseOrderDetails;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();
    Products saveProduct(Products products);
    Products getProductById(String productCode);

    void updateProductStock(List<PurchaseOrderDetails> orderDetails);
}
