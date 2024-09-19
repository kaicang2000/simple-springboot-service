package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.Products;
import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.entities.PurchaseOrders;
import com.example.webservicecangpt.repositories.ProductRepository;
import com.example.webservicecangpt.repositories.PurchaseOrderDetailsRepository;
import com.example.webservicecangpt.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrdersRepository;

    @Autowired
    private PurchaseOrderDetailsRepository purchaseOrderDetailsRepository;

    // Action 1: Insert a purchase order to PurchaseOrders and PurchaseOrderDetails using SQL commands
    // Insert a purchase order and its details
    public void insertPurchaseOrder(PurchaseOrders order, List<PurchaseOrderDetails> details) {
        // Save the purchase order
        purchaseOrdersRepository.save(order);

        // Save each purchase order detail
        for (PurchaseOrderDetails detail : details) {
                purchaseOrderDetailsRepository.save(detail);
        }
    }

    // Update product quantities and prices based on purchase details
    public void updateProductsAfterPurchase(List<PurchaseOrderDetails> details) {
        for (PurchaseOrderDetails detail : details) {
            Products product = productRepository.findById(detail.getProductCode()).orElse(null);
            if (product != null) {
                // Calculate the new quantity in stock
                double newQuantityInStock = product.getQuantityInStock() + detail.getQuantity();

                // Calculate the new unit price using weighted average formula
                double newUnitPrice = ((product.getQuantityInStock() * product.getUnitPrice()) +
                        (detail.getQuantity() * detail.getPurchasePrice()))
                        / newQuantityInStock;

                // Update the product's quantity in stock and unit price
                product.setQuantityInStock(newQuantityInStock);
                product.setUnitPrice(newUnitPrice);

                // Save the updated product
                productRepository.save(product);
            }
        }
    }
}


