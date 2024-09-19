package com.example.webservicecangpt.controllers;

import com.example.webservicecangpt.dto.PurchaseOrderRequest;
import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.entities.PurchaseOrders;
import com.example.webservicecangpt.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    // Insert a new purchase order with its details
    @PostMapping
    public ResponseEntity<String> insertPurchaseOrder(
                @RequestBody PurchaseOrderRequest request) {

        PurchaseOrders order = request.getOrder();
        List<PurchaseOrderDetails> details = request.getDetails();

        // Insert the purchase order and its details
        purchaseOrderService.insertPurchaseOrder(order, details);

        // Update the product quantities and prices
        purchaseOrderService.updateProductsAfterPurchase(details);

        return ResponseEntity.ok("Purchase Order and Details inserted successfully, Products updated.");
    }
}
