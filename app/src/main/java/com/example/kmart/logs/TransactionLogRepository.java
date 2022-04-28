package com.example.kmart.logs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

import java.util.ArrayList;
import java.util.Locale;

public class TransactionLogRepository {
    private SQLiteDatabase database;

    public TransactionLogRepository(Context context) {
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public void saveTransactionLog(TransactionLog transactionLog) {
        String query = String.format(Locale.getDefault(), "INSERT INTO transaction_log(transaction_value, transaction_type) VALUES (%f, %d);", transactionLog.getTransactionValue(), transactionLog.getTransactionType());

        this.database.execSQL(query);
    }

    public ArrayList<TransactionLog> getAllLogs() {
        return null;
    }
}
