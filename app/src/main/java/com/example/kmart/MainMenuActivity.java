package com.example.kmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.kmart.inventory.InventoryProductListActivity;
import com.example.kmart.inventory.SellProductActivity;
import com.example.kmart.logs.TransactionLogListActivity;
import com.example.kmart.stats.KmartStatsActivity;

public class MainMenuActivity extends AppCompatActivity {
    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void openSellProductActivity() {
        openActivity(SellProductActivity.class);
    }

    private void openLogListActivity() {
        openActivity(TransactionLogListActivity.class);
    }
    private void openInventoryActivity() {
        openActivity(InventoryProductListActivity.class);
    }
    private void openStatsActivity() {
        openActivity(KmartStatsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button openSellBtn = findViewById(R.id.open_sell_product_btn);
        Button openLogListBtn = findViewById(R.id.open_logs_btn);
        Button openInventoryBtn = findViewById(R.id.open_inventory_btn);
        Button openStatsBtn = findViewById(R.id.open_stats_btn);

        openSellBtn.setOnClickListener(it -> openSellProductActivity());
        openLogListBtn.setOnClickListener(it -> openLogListActivity());
        openInventoryBtn.setOnClickListener(it -> openInventoryActivity());
        openStatsBtn.setOnClickListener(it -> openStatsActivity());
    }
}