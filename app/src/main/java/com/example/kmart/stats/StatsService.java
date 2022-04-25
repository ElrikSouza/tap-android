package com.example.kmart.stats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

public class StatsService {
    private SQLiteDatabase database;

    public StatsService(Context context) {
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public ProfitStats getProfitBreakdown() {
        return null;
    }

    public SaleStats getSalesBreakdown() {
        return null;
    }
}
