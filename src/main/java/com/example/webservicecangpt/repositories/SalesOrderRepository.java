package com.example.webservicecangpt.repositories;

import com.example.webservicecangpt.entities.SalesOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrders, String> { }
