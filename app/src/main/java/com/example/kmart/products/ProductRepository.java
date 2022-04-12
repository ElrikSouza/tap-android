package com.example.kmart.products;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

public class ProductRepository {
    private Context context;
    private SQLiteDatabase database;

    private final static String GET_BY_BARCODE = "SELECT * FROM product WHERE barcode = ?;";

    public ProductRepository(Context context) {
        this.context = context;
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public Product getProductByBarcode(String searchBarcode) {
        Product product = null;

        Cursor cursor = this.database.rawQuery(GET_BY_BARCODE, new String[]{searchBarcode});

        if (cursor.moveToFirst()) {
            String barcode = cursor.getString(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String measuringUnit = cursor.getString(3);
            double supplierPrice = cursor.getDouble(4);
            double sellPrice = cursor.getDouble(5);
            int quantityAvailable = cursor.getInt(6);

            product = new Product(barcode, name, description, measuringUnit, supplierPrice, sellPrice, quantityAvailable);
        }

        return product;
    }
}
