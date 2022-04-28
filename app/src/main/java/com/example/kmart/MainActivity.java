package com.example.kmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.kmart.inventory.BuyProductActivity;
import com.example.kmart.inventory.InventoryProductListActivity;
import com.example.kmart.inventory.PaymentActivity;
import com.example.kmart.inventory.SellProductActivity;
import com.example.kmart.logs.TransactionLogListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}