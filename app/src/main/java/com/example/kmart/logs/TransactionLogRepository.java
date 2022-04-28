package com.example.kmart.logs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TransactionLogRepository {
    private SQLiteDatabase database;

    public TransactionLogRepository(Context context) {
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    public void saveTransactionLog(TransactionLog transactionLog) {
        String date = new SimpleDateFormat("dd/mm/yyyy").format(transactionLog.getTransactionDate());
        String query = String.format(Locale.getDefault(), "INSERT INTO transaction_log(transaction_value, transaction_type, timestamp) VALUES (%f, %d, '%s');", transactionLog.getTransactionValue(), transactionLog.getTransactionType(), date);

        this.database.execSQL(query);
    }

    private TransactionLog getTransactionLogFromCursor(Cursor queryCursor) {
        double value = queryCursor.getDouble(1);
        int type = queryCursor.getInt(2);

        try {
            Date timestamp = new SimpleDateFormat("dd/mm/yyyy").parse(queryCursor.getString(3));
            return new TransactionLog(value, type, timestamp);
        } catch (Exception e){
            return new TransactionLog(value, type, new Date());
        }
    }

    public ArrayList<TransactionLog> getAllLogs() {
        Cursor cursor = this.database.rawQuery("SELECT * from transaction_log;", new String[]{});

        ArrayList<TransactionLog> logs = new ArrayList<>();

        while (cursor.moveToNext()) {
           logs.add(getTransactionLogFromCursor(cursor));
        }

        return logs;
    }
}
