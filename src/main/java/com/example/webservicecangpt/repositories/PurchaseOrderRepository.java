package com.example.webservicecangpt.repositories;

import com.example.webservicecangpt.entities.PurchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrders, String> { }
