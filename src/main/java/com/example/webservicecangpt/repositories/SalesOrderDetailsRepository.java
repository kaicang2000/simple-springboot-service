package com.example.webservicecangpt.repositories;

import com.example.webservicecangpt.entities.SalesOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderDetailsRepository extends JpaRepository<SalesOrderDetails, String> { }
