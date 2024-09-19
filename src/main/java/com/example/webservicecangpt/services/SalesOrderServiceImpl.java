package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.Products;
import com.example.webservicecangpt.entities.SalesOrderDetails;
import com.example.webservicecangpt.entities.SalesOrders;
import com.example.webservicecangpt.repositories.ProductRepository;
import com.example.webservicecangpt.repositories.SalesOrderDetailsRepository;
import com.example.webservicecangpt.repositories.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrdersRepository;

    @Autowired
    private SalesOrderDetailsRepository salesOrderDetailsRepository;

    @Autowired
    private ProductRepository productsRepository;

    @Override
    public void createSalesOrder(SalesOrders order, List<SalesOrderDetails> details) {
        // Step 1: Insert the Sales Order
        salesOrdersRepository.save(order);

        // Step 2: Insert Sales Order Details and update Products
        for (SalesOrderDetails detail : details) {
            // Insert each detail
            salesOrderDetailsRepository.save(detail);

            // Update the Products table based on sales details (subtract the quantity)
            Products product = productsRepository.findById(detail.getProductCode()).orElseThrow(
                    () -> new RuntimeException("Product not found"));

            double newQuantityInStock = product.getQuantityInStock() - detail.getQuantity();

            product.setQuantityInStock(newQuantityInStock);

            productsRepository.save(product);
        }
    }

    @Override
    public void updateProductsAfterSales(List<SalesOrderDetails> details) {
        for (SalesOrderDetails detail : details) {
            Products product = productsRepository.findById(detail.getProductCode()).orElse(null);
            if (product != null) {
                // Decrease the quantity in stock by the quantity sold
                product.setQuantityInStock(product.getQuantityInStock() - detail.getQuantity());

                // Save the updated product
                productsRepository.save(product);
            }
        }
    }
}
