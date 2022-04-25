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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmart_stats);

        StatsService statsService = new StatsService(this);
        ProfitStats profitStats = statsService.getProfitBreakdown();

        displayProfitBreakdown(profitStats);
    }
}