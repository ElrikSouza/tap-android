package com.example.kmart.inventory;

import com.example.kmart.products.Product;

public class SaleEntry {
    private Product product;
    private int quantity;

    public SaleEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
