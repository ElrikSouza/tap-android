package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kmart.R;
import com.example.kmart.products.Product;

import java.util.ArrayList;

public class SellProductActivity extends AppCompatActivity {
    private Inventory inventory;
    private RecyclerView shoppingCart;
    private Button openPaymentActivityButton, addProductToCartButton;
    private EditText barcodeField, quantityField;
    private ArrayList<SaleEntry> saleEntries;
    private ShoppingCartAdapter adapter;

    private void addProductToCart() {
        try {
            String barcode = barcodeField.getText().toString();
            int quantity = Integer.parseInt(quantityField.getText().toString());
            Product product = inventory.getOneProductViaBarcode(barcode);
            saleEntries.add(new SaleEntry(product, quantity));
            this.adapter.setProductList(saleEntries);
        } catch (Exception e) {
            Toast.makeText(this, "Produto inexistente", Toast.LENGTH_SHORT).show();
        } finally {
            barcodeField.setText("");
            quantityField.setText("");
        }
    }

    private void openPaymentActivity() {
    }

    private void removeProductFromCart(String barcode) {
        saleEntries.removeIf(entry -> entry.getProduct().getBarcode().equals(barcode));
        this.adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_product);
        this.inventory = new Inventory(this);

        this.saleEntries = new ArrayList<SaleEntry>();
        this.shoppingCart = findViewById(R.id.sell_product_cart_list);
        this.openPaymentActivityButton = findViewById(R.id.sell_product_confirm_btn);
        this.addProductToCartButton = findViewById(R.id.sell_product_add_to_cart_btn);
        this.barcodeField = findViewById(R.id.sell_product_barcode_field);
        this.quantityField = findViewById(R.id.sell_product_quantity);

        this.adapter = new ShoppingCartAdapter(this, this::removeProductFromCart);
        this.adapter.setProductList(saleEntries);
        this.shoppingCart.setLayoutManager(new LinearLayoutManager(this));
        this.shoppingCart.setAdapter(adapter);


        this.openPaymentActivityButton.setOnClickListener(it -> this.openPaymentActivity());
        this.addProductToCartButton.setOnClickListener(it -> this.addProductToCart());
    }
}