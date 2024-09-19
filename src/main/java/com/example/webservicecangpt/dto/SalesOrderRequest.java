package com.example.webservicecangpt.dto;

import com.example.webservicecangpt.entities.SalesOrderDetails;
import com.example.webservicecangpt.entities.SalesOrders;

import java.util.List;

public class SalesOrderRequest {
    private SalesOrders order;
    private List<SalesOrderDetails> details;

    // Getters and Setters
    public SalesOrders getOrder() {
        return order;
    }

    public void setOrder(SalesOrders order) {
        this.order = order;
    }

    public List<SalesOrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<SalesOrderDetails> details) {
        this.details = details;
    }
}

