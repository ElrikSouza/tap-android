package com.example.kmart.inventory;

import android.content.Context;

import com.example.kmart.products.Product;
import com.example.kmart.products.ProductRepository;

import java.util.ArrayList;

public class Inventory {
    private ProductRepository productRepository;

    public Inventory(Context context) {
        this.productRepository = new ProductRepository(context);
    }

    public ArrayList<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    public Product getOnProductViaBarcode(String barcode) {
        return this.productRepository.getProductByBarcode(barcode);
    }

    public void buyProduct(Product productToBeBought) {

    }
}
