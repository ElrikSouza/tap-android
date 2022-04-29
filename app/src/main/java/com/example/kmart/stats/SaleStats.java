package com.example.kmart.stats;

public class SaleStats {
    private double totalRevenueFromCash;
    private int numOfPaymentsInCash;
    private double totalRevenueFromDebit;
    private int numOfPaymentsInDebit;
    private double totalRevenueFromCredit;
    private int numOfPaymentsInCredit;
    private double averageChangeValue;

    public SaleStats(double totalRevenueFromCash, int numOfPaymentsInCash, double totalRevenueFromDebit, int numOfPaymentsInDebit, double totalRevenueFromCredit, int numOfPaymentsInCredit, double averageChangeValue) {
        this.totalRevenueFromCash = totalRevenueFromCash;
        this.numOfPaymentsInCash = numOfPaymentsInCash;
        this.totalRevenueFromDebit = totalRevenueFromDebit;
        this.numOfPaymentsInDebit = numOfPaymentsInDebit;
        this.totalRevenueFromCredit = totalRevenueFromCredit;
        this.numOfPaymentsInCredit = numOfPaymentsInCredit;
        this.averageChangeValue = averageChangeValue;
    }

    public double getTotalRevenueFromCash() {
        return totalRevenueFromCash;
    }

    public int getNumOfPaymentsInCash() {
        return numOfPaymentsInCash;
    }

    public double getTotalRevenueFromDebit() {
        return totalRevenueFromDebit;
    }

    public int getNumOfPaymentsInDebit() {
        return numOfPaymentsInDebit;
    }

    public double getTotalRevenueFromCredit() {
        return totalRevenueFromCredit;
    }

    public int getNumOfPaymentsInCredit() {
        return numOfPaymentsInCredit;
    }

    public double getAverageChangeValue() {
        return averageChangeValue;
    }

    public double getAveragePaymentInCash() {
        if (numOfPaymentsInCash == 0) {
            return 0;
        }

        return totalRevenueFromCash / numOfPaymentsInCash;
    }

    public double getAveragePaymentInDebit() {
        if (numOfPaymentsInDebit == 0) {
            return 0;
        }

        return totalRevenueFromDebit / numOfPaymentsInDebit;
    }

    public double getAveragePaymentInCredit() {
        if (numOfPaymentsInCredit == 0) {
            return 0;
        }

        return totalRevenueFromCredit / numOfPaymentsInCredit;
    }
}
