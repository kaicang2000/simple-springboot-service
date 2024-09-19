package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.Products;
import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    public Products getProductById(String productCode) {
        return productRepository.getReferenceById(productCode);
    }

    @Override
    public void updateProductStock(List<PurchaseOrderDetails> orderDetails) {
        for (PurchaseOrderDetails detail : orderDetails) {
            Products product = productRepository.findById(detail.getProductCode()).orElseThrow(
                    () -> new RuntimeException("Product not found"));

            double newQuantityInStock = product.getQuantityInStock() + detail.getQuantity();
            double newUnitPrice = ((product.getQuantityInStock() * product.getUnitPrice()) +
                    (detail.getQuantity() * detail.getPurchasePrice())) /
                    newQuantityInStock;

            product.setQuantityInStock(newQuantityInStock);
            product.setUnitPrice(newUnitPrice);

            productRepository.save(product);
        }
    }
}
