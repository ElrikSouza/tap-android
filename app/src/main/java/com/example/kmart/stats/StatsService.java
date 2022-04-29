package com.example.kmart.stats;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

public class StatsService {
    private SQLiteDatabase database;

    public StatsService(Context context) {
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public ProfitStats getProfitBreakdown() {
        Cursor cursor = this.database.rawQuery("SELECT SUM(quantity_available * supplier_price), SUM(sell_price * quantity_available) FROM product", new String[]{});

        cursor.moveToNext();

        double totalValue = cursor.getDouble(0);
        double totalSellPrice = cursor.getDouble(1);

        return new ProfitStats(totalValue, totalSellPrice);
    }

    public SaleStats getSalesBreakdown() {
        String query = "SELECT SUM(total_paid), COUNT(id) FROM sale_record WHERE payment_method = ?;" ;

       Cursor cursor = this.database.rawQuery(query, new String[]{"0"});
       cursor.moveToFirst();
       double paidCash = cursor.getDouble(0);
       int totalCash = cursor.getInt(1);
       cursor.close();

        cursor = this.database.rawQuery(query, new String[]{"1"});
        cursor.moveToFirst();
        double paidDebit = cursor.getDouble(0);
        int totalDebit = cursor.getInt(1);
        cursor.close();

        cursor = this.database.rawQuery(query, new String[]{"2"});
        cursor.moveToFirst();
        double paidCredit = cursor.getDouble(0);
        int totalCredit = cursor.getInt(1);
        cursor.close();

        cursor = this.database.rawQuery("SELECT AVG(change) FROM sale_record", new String[]{});
        cursor.moveToFirst();
        double avgChange = cursor.getDouble(0);

        return new SaleStats(paidCash, totalCash, paidDebit, totalDebit, paidCredit, totalCredit, avgChange);
    }
}
