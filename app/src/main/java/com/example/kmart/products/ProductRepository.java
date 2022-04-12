package com.example.kmart.products;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.kmart.localdb.LocalDatabase;

import java.util.ArrayList;
import java.util.Locale;

public class ProductRepository {
    private final static String GET_BY_BARCODE = "SELECT * FROM product WHERE barcode = ?;";
    private final static String GET_ALL = "SELECT * FROM product";
    private Context context;
    private SQLiteDatabase database;

    public ProductRepository(Context context) {
        this.context = context;
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    private Product getProductFromCursor(Cursor cursor) {
        String barcode = cursor.getString(0);
        String name = cursor.getString(1);
        String description = cursor.getString(2);
        String measuringUnit = cursor.getString(3);
        double supplierPrice = cursor.getDouble(4);
        double sellPrice = cursor.getDouble(5);
        int quantityAvailable = cursor.getInt(6);


        return new Product(barcode, name, description, measuringUnit, supplierPrice, sellPrice, quantityAvailable);
    }

    public Product getProductByBarcode(String searchBarcode) {
        Product product = null;

        Cursor cursor = this.database.rawQuery(GET_BY_BARCODE, new String[]{searchBarcode});

        if (cursor.moveToFirst()) {
            product = getProductFromCursor(cursor);
        }

        return product;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList();

        Cursor cursor = this.database.rawQuery(GET_ALL, new String[]{});

        while (cursor.moveToNext()) {
            Product currentProduct = getProductFromCursor(cursor);
            products.add(currentProduct);
        }

        return products;
    }

    public void saveProduct(Product product) {
        String query = String.format(Locale.getDefault(),"INSERT INTO product VALUES (%s, %s, %s, %s, %f, %f, %d);",
                        product.getBarcode(), product.getName(), product.getDescription(), product.getMeasuringUnit(), product.getSupplierPrice(), product.getSellPrice(), product.getQuantityAvailable());

        this.database.execSQL(query);
    }

    public void updateProduct(Product product) {
        String query = String.format(Locale.getDefault(), "UPDATE product SET name='%s', description='%s', measuring_unit='%s', supplier_price=%f, sell_price=%f, quantity_available=%d WHERE barcode='%s'",
                product.getName(), product.getDescription(), product.getMeasuringUnit(), product.getSupplierPrice(), product.getSellPrice(), product.getQuantityAvailable(), product.getBarcode());

        this.database.execSQL(query);
    }

    public void deleteProductByBarcode(String barcode) {
        String query = String.format(Locale.getDefault(), "DELETE FROM product WHERE barcode='%s';", barcode);

        this.database.execSQL(query);
    }
}
