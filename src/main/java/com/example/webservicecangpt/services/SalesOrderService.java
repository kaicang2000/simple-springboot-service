package com.example.webservicecangpt.services;

import com.example.webservicecangpt.entities.SalesOrderDetails;
import com.example.webservicecangpt.entities.SalesOrders;

import java.util.List;

public interface SalesOrderService {
    void createSalesOrder(SalesOrders order, List<SalesOrderDetails> details);
    void updateProductsAfterSales(List<SalesOrderDetails> details);
}
