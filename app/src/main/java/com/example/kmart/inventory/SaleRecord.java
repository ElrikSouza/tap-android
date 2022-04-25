package com.example.kmart.inventory;

public class SaleRecord {
    private int paymentMethod;
    private double totalPaid;
    private double totalSupplierCost;
    private double change;

    public SaleRecord(int paymentMethod, double totalPaid, double totalSupplierCost, double change) {
        this.paymentMethod = paymentMethod;
        this.totalPaid = totalPaid;
        this.totalSupplierCost = totalSupplierCost;
        this.change = change;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public double getTotalSupplierCost() {
        return totalSupplierCost;
    }

    public double getChange() {
        return change;
    }
}
