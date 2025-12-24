package com.unifacisa.ads.rango.item.core;

import com.unifacisa.ads.rango.product.core.Product;

import java.math.BigDecimal;

public class Item {

    private Product product;

    private Integer quantity;

    private BigDecimal unitPrice;

    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public void increaseQuantity(int additionalQuantity) {
        this.quantity += additionalQuantity;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public BigDecimal getSubtotal() {
        return this.unitPrice.multiply(new BigDecimal(this.quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
