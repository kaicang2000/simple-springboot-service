package com.example.webservicecangpt.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Column(name = "ProductName", length = 150)
    private String productName;

    @Column(name = "Unit", length = 20)
    private String unit;

    @Column(name = "QuantityInStock", columnDefinition = "float default 0")
    private double quantityInStock;

    @Column(name = "UnitPrice", columnDefinition = "float default 0")
    private double unitPrice;

    @Column(name = "CreatedByDate")
    @Temporal(TemporalType.DATE)
    private Date createdByDate;

    @Column(name = "CreatedBy", length = 20)
    private String createdBy;

    //Getters and Setters

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
