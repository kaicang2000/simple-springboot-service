package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.entities.PurchaseOrders;

import java.util.List;

public interface PurchaseOrderService {
    void insertPurchaseOrder(PurchaseOrders order, List<PurchaseOrderDetails> details);
    void updateProductsAfterPurchase(List<PurchaseOrderDetails> details);
}
