package com.example.kmart.logs;

public class TransactionLog {
    private int id;
    private double transactionValue;
    private int transactionType;

    public TransactionLog(int id, double transactionValue, int transactionType) {
       this.id = id;
       this.transactionValue = transactionValue;
       this.transactionType= transactionType;
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
}
