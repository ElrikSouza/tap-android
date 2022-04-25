package com.example.kmart.stats;

public class ProfitStats {
    private double totalValueInProducts;
    private double totalSaleRevenue;
    private double totalSupplierCost;

    public ProfitStats(double totalValueInProducts, double totalSaleRevenue, double totalSupplierCost) {
        this.totalValueInProducts = totalValueInProducts;
        this.totalSaleRevenue = totalSaleRevenue;
        this.totalSupplierCost = totalSupplierCost;
    }

    public double getTotalValueInProducts() {
        return totalValueInProducts;
    }

    public double getTotalSaleRevenue() {
        return totalSaleRevenue;
    }

    public double getTotalSupplierCost() {
        return totalSupplierCost;
    }

    public double getProfit() {
        return totalSaleRevenue - totalSupplierCost;
    }
}
