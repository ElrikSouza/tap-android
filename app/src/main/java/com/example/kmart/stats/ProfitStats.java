package com.example.kmart.stats;

public class ProfitStats {
    private double totalValueInProducts;
    private double totalSaleRevenue;

    public ProfitStats(double totalValueInProducts, double totalSaleRevenue) {
        this.totalValueInProducts = totalValueInProducts;
        this.totalSaleRevenue = totalSaleRevenue;
    }

    public double getTotalValueInProducts() {
        return totalValueInProducts;
    }

    public double getTotalSaleRevenue() {
        return totalSaleRevenue;
    }

    public double getProfit() {
        return totalSaleRevenue - totalValueInProducts;
    }
}
