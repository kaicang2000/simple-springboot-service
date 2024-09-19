package com.example.webservicecangpt.repositories;

import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDetailsRepository extends JpaRepository<PurchaseOrderDetails, String> { }
