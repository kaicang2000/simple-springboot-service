package com.example.webservicecangpt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PurchaseOrderDetails")
@IdClass(PurchaseOrderDetailId.class) // Composite key
public class PurchaseOrderDetails {

    @Id
    @Column(name = "OrderNo", length = 6)
    private String orderNo;

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Column(name = "Quantity", columnDefinition = "float default 0")
    private double quantity;

    @Column(name = "PurchasePrice", columnDefinition = "float default 0")
    private double purchasePrice;

    @Column(name = "Tax", columnDefinition = "float default 0")
    private double tax;

    // Getters and Setters

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}

