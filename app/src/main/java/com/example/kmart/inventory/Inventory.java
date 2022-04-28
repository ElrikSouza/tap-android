package com.example.kmart.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;
import com.example.kmart.logs.TransactionLog;
import com.example.kmart.logs.TransactionLogRepository;
import com.example.kmart.products.Product;
import com.example.kmart.products.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Inventory {
    private ProductRepository productRepository;
    private TransactionLogRepository transactionLogRepository;
    private SQLiteDatabase database;

    public Inventory(Context context) {
        this.productRepository = new ProductRepository(context);
        this.transactionLogRepository = new TransactionLogRepository(context);
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public ArrayList<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    public Product getOneProductViaBarcode(String barcode) throws Exception {
        Product product = this.productRepository.getProductByBarcode(barcode);

        if (product == null) {
            throw new Exception("Produto nao encontrado");
        }

        return product;
    }

    public void buyProduct(Product productToBeBought) {
        productRepository.saveProduct(productToBeBought);

        TransactionLog log = new TransactionLog(-1 * productToBeBought.getQuantityAvailable() * productToBeBought.getSellPrice(), 0, new Date());
        transactionLogRepository.saveTransactionLog(log);
    }

    private void saveSaleRecord(SaleRecord saleRecord) {
        String query = String.format(Locale.getDefault(), "INSERT INTO sale_record(total_paid, payment_method, total_supplier_price, change) VALUES (%f, %d, %f, %f)", saleRecord.getTotalPaid(), saleRecord.getPaymentMethod(), saleRecord.getTotalSupplierCost(), saleRecord.getChange());

        this.database.execSQL(query);
    }

    public void sellProduct(SaleRecord saleRecord) {
        TransactionLog log = new TransactionLog(saleRecord.getTotalPaid() - saleRecord.getChange(), 1, new Date());
        transactionLogRepository.saveTransactionLog(log);
        this.saveSaleRecord(saleRecord);
    }
}
