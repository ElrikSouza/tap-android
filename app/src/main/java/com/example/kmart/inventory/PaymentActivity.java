package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.kmart.R;

public class PaymentActivity extends AppCompatActivity {
    private Spinner selectPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        this.selectPaymentMethod = findViewById(R.id.select_payment_method_spinner);
        String[] paymentOptions = new String[]{"Dinheiro", "Debito", "Credito"};
        this.selectPaymentMethod.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,paymentOptions));
    }
}