package com.example.kmart.inventory;

import android.content.Context;

import com.example.kmart.logs.TransactionLog;
import com.example.kmart.logs.TransactionLogRepository;
import com.example.kmart.products.Product;
import com.example.kmart.products.ProductRepository;

import java.util.ArrayList;

public class Inventory {
    private ProductRepository productRepository;
    private TransactionLogRepository transactionLogRepository;

    public Inventory(Context context) {
        this.productRepository = new ProductRepository(context);
    }

    public ArrayList<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    public Product getOneProductViaBarcode(String barcode) {
//        return this.productRepository.getProductByBarcode(barcode);
        return new Product("cart", "cart", "cart", "unit", 12, 12, 12);
    }

    public void buyProduct(Product productToBeBought) {
        productRepository.saveProduct(productToBeBought);

        TransactionLog log = new TransactionLog(-1 * productToBeBought.getQuantityAvailable() * productToBeBought.getSellPrice(), 0);
        transactionLogRepository.saveTransactionLog(log);
    }

    public void sellProduct(SaleData saleData) {

    }
}
