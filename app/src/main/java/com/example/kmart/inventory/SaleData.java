package com.example.kmart.inventory;

public class SaleData {
    private int paymentMethod;
    private double totalSellRevenue;
    private double totalSupplierCost;
    private double change;

    public SaleData(int paymentMethod, double totalSellRevenue, double totalSupplierCost, double change) {
        this.paymentMethod = paymentMethod;
        this.totalSellRevenue = totalSellRevenue;
        this.totalSupplierCost = totalSupplierCost;
        this.change = change;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalSellRevenue() {
        return totalSellRevenue;
    }

    public double getTotalSupplierCost() {
        return totalSupplierCost;
    }

    public double getChange() {
        return change;
    }
}
