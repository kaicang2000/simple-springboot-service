package com.example.webservicecangpt.dto;

import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.entities.PurchaseOrders;

import java.util.List;

public class PurchaseOrderRequest {

    private PurchaseOrders order;
    private List<PurchaseOrderDetails> details;

    // Getters and Setters
    public PurchaseOrders getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrders order) {
        this.order = order;
    }

    public List<PurchaseOrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseOrderDetails> details) {
        this.details = details;
    }
}

