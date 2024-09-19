package com.example.webservicecangpt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SalesOrderDetails")
@IdClass(SalesOrderDetailId.class) // Composite key
public class SalesOrderDetails {

    @Id
    @Column(name = "OrderNo", length = 6)
    private String orderNo;

    @Id
    @Column(name = "ProductCode", length = 6)
    private String productCode;

    @Column(name = "Quantity", columnDefinition = "float default 0")
    private double quantity;

    @Column(name = "SalesPrice", columnDefinition = "float default 0")
    private double salesPrice;

    @Column(name = "Tax", columnDefinition = "float default 0")
    private double tax;

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

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}

