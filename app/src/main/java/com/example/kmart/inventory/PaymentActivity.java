package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kmart.MainActivity;
import com.example.kmart.R;

import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {
    private Spinner selectPaymentMethod;
    private EditText totalPaidField;
    private double totalSupplierPrice;
    private double totalSellPrice;
    private Inventory inventory;

    private int getPaymentMethodId() {
        String paymentMethodString = (String) selectPaymentMethod.getSelectedItem();

        if (paymentMethodString.equals("Dinheiro")) {
            return 0;
        } else if (paymentMethodString.equals("Debito")) {
            return 1;
        } else {
            return 2;
        }
    }

    private void returnToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void finishSale() {
        Double totalPaid = Double.parseDouble(totalPaidField.getText().toString());
       SaleRecord record = new SaleRecord(getPaymentMethodId(), totalPaid, totalSupplierPrice, totalPaid - totalSellPrice);
       this.inventory.sellProduct(record);

       String message = String.format(Locale.getDefault(), "Compra finalizada. O troco foi de R$ %.2ff", totalPaid - totalSellPrice);

       Toast.makeText(this, message, Toast.LENGTH_LONG);

       returnToMainScreen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        this.selectPaymentMethod = findViewById(R.id.select_payment_method_spinner);
        this.totalPaidField = findViewById(R.id.finish_sale_total_paid);
        String[] paymentOptions = new String[]{"Dinheiro", "Debito", "Credito"};
        this.selectPaymentMethod.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,paymentOptions));
        this.inventory = new Inventory(this);

        Intent intent = getIntent();
        this.totalSellPrice = intent.getDoubleExtra("total_sell", 0);
        this.totalSupplierPrice= intent.getDoubleExtra("total_supplier", 0);

        TextView totalPaidLabel = findViewById(R.id.to_be_paid_label);
        totalPaidLabel.setText(String.format(Locale.getDefault(), "Total a ser pago %.2f R$", this.totalSellPrice));
         Button finishSaleButton= findViewById(R.id.finish_sale_btn);
         finishSaleButton.setOnClickListener(l -> finishSale());
    }
}