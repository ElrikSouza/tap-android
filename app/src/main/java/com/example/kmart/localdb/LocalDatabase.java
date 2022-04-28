package com.example.kmart.localdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kmart.db";

    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " +
            "product(barcode TEXT PRIMARY KEY, name TEXT NOT NULL, " +
            "description TEXT NOT NULL, measuring_unit TEXT NOT NULL, " +
            "supplier_price REAL NOT NULL, sell_price REAL NOT NULL, quantity_available INTEGER NOT NULL);";

    private static final String CREATE_TRANSACTION_LOG_TABLE = "CREATE TABLE transaction_log(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "transaction_value REAL NOT NULL, transaction_type INTEGER, timestamp INTEGER);";

    private static final String CREATE_SALE_RECORD_TABLE = "CREATE TABLE sale_record(id INTEGER PRIMARY KEY AUTOINCREMENT, total_paid REAL, payment_method INTEGER, REAL, total_supplier_price REAL, change REAL);";



    public LocalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDb) {
        sqliteDb.execSQL(CREATE_PRODUCT_TABLE);
        sqliteDb.execSQL(CREATE_TRANSACTION_LOG_TABLE);
        sqliteDb.execSQL(CREATE_SALE_RECORD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDb, int previousVersion, int currentVersion) {
    }
}