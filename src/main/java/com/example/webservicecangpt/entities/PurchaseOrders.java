package com.example.webservicecangpt.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PurchaseOrders")
public class PurchaseOrders {

    @Id
    @Column(name = "OrderNo", length = 6)
    private String orderNo;

    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "Title", length = 50)
    private String title;

    @Column(name = "Description", length = 200)
    private String description;

    @Column(name = "CreatedByDate")
    @Temporal(TemporalType.DATE)
    private Date createdByDate;

    @Column(name = "CreatedBy", length = 20)
    private String createdBy;

    // Getters and Setters

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(Date createdByDate) {
        this.createdByDate = createdByDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
