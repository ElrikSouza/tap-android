package com.example.kmart.stats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.kmart.R;

import java.util.Locale;

public class KmartStatsActivity extends AppCompatActivity {

    private void displayProfitBreakdown(ProfitStats profitStats) {
        TextView totalValueInProductsLabel = findViewById(R.id.value_in_produts_lbl);
        TextView profitLabel = findViewById(R.id.profit_label);
        TextView profitCalculationLabel = findViewById(R.id.profit_calculation_lbl);

        String totalValueInProductsText = String.format(Locale.getDefault(), "Valor total em produtos: %.2f R$", profitStats.getTotalValueInProducts());
        String profitText = String.format(Locale.getDefault(), "Lucro: %.2f R$", profitStats.getProfit());
        String profitCalculationText = String.format(Locale.getDefault(), "Calculado de (%.2f - %.2f)", profitStats.getTotalSaleRevenue(), profitStats.getTotalSupplierCost());

        totalValueInProductsLabel.setText(totalValueInProductsText);
        profitLabel.setText(profitText);
        profitCalculationLabel.setText(profitCalculationText);
    }

    private void displaySalesBreakdown(SaleStats saleStats) {
        TextView numOfPaymentsInCashLabel = findViewById(R.id.cash_total);
        TextView cashAvgPaymentLabel = findViewById(R.id.cash_avg_val);

        TextView numOfPaymentsInDebitLabel = findViewById(R.id.debit_total);
        TextView debitAvgPaymentLabel = findViewById(R.id.debit_avg_val);

        TextView numOfPaymentsInCreditLabel = findViewById(R.id.credit_total);
        TextView creditAvgPaymentLabel = findViewById(R.id.credit_avg_val);

        numOfPaymentsInCashLabel.setText(String.format(Locale.getDefault(), "Numero total de transações: %d", saleStats.getNumOfPaymentsInCash()));
        numOfPaymentsInDebitLabel.setText(String.format(Locale.getDefault(), "Numero total de transações: %d", saleStats.getNumOfPaymentsInDebit()));
        numOfPaymentsInCreditLabel.setText(String.format(Locale.getDefault(), "Numero total de transações: %d", saleStats.getNumOfPaymentsInCredit()));

        cashAvgPaymentLabel.setText(String.format(Locale.getDefault(), "Valor médio da compra: R$ %.2f", saleStats.getAveragePaymentInCash()));
        debitAvgPaymentLabel.setText(String.format(Locale.getDefault(), "Valor médio da compra: R$ %.2f", saleStats.getAveragePaymentInDebit()));
        creditAvgPaymentLabel.setText(String.format(Locale.getDefault(), "Valor médio da compra: R$ %.2f", saleStats.getAveragePaymentInCredit()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmart_stats);

        StatsService statsService = new StatsService(this);
        ProfitStats profitStats = statsService.getProfitBreakdown();
        SaleStats saleStats = statsService.getSalesBreakdown();

        displayProfitBreakdown(profitStats);
        displaySalesBreakdown(saleStats);
    }
}