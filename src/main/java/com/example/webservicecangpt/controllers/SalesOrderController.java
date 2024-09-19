package com.example.webservicecangpt.controllers;

import com.example.webservicecangpt.dto.SalesOrderRequest;
import com.example.webservicecangpt.entities.SalesOrderDetails;
import com.example.webservicecangpt.entities.SalesOrders;
import com.example.webservicecangpt.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales-order")
public class SalesOrderController {

    @Autowired
    SalesOrderService salesOrderService;

    @PostMapping
    public ResponseEntity<String> createSalesOrder (
            @RequestBody SalesOrderRequest request) {

        // Extract the SalesOrders and SalesOrderDetails from the request
        SalesOrders order = request.getOrder();
        List<SalesOrderDetails> details = request.getDetails();

        // Insert the sales order and its details
        salesOrderService.createSalesOrder(order, details);

        // Update the product quantities after the sale
        salesOrderService.updateProductsAfterSales(details);

        return ResponseEntity.ok("Sales Order and Details inserted successfully, Products updated.");
    }
}
