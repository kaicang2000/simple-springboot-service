package com.example.webservicecangpt.entities;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseOrderDetailId implements Serializable {
    private String orderNo;
    private String productCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderDetailId that = (PurchaseOrderDetailId) o;
        return Objects.equals(orderNo, that.orderNo) && Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, productCode);
    }
}
