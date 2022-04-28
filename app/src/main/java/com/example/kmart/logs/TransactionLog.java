package com.example.kmart.logs;

import java.util.Date;

public class TransactionLog {
    private int id;
    private double transactionValue;
    private int transactionType;
    private Date transactionDate;

    public TransactionLog(int id, double transactionValue, int transactionType) {
       this.id = id;
       this.transactionValue = transactionValue;
       this.transactionType = transactionType;
       this.transactionDate = null;
    }

    public TransactionLog(double transactionValue, int transactionType) {
        this.id = -1;
        this.transactionValue = transactionValue;
        this.transactionType= transactionType;
    }

    public int getId() {
        return id;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}
