package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kmart.R;
import com.example.kmart.products.Product;

public class BuyProductActivity extends AppCompatActivity {
    private EditText productBarcode;
    private EditText productName;
    private EditText productDescription;
    private EditText productSellPrice;
    private EditText productSupplierPrice;
    private EditText productMeasuringUnit;
    private EditText productQuantity;

    private Inventory inventory;

    private Product getProductFromForm() {
        String barcode = productBarcode.getText().toString();
        String name = productName.getText().toString();
        String description = productDescription.getText().toString();
        String measuringUnit = productMeasuringUnit.getText().toString();
        double sellPrice = Double.parseDouble(productSellPrice.getText().toString());
        double supplierPrice = Double.parseDouble(productSupplierPrice.getText().toString());
        int quantity = Integer.parseInt(productQuantity.getText().toString());

        return new Product(barcode, name, description, measuringUnit, supplierPrice, sellPrice, quantity);
    }

    private void goBackToMainInventoryScree() {
        Intent intent = new Intent(this, InventoryProductListActivity.class);
        startActivity(intent);
    }

    private void confirmProductPurchase() {
        Product productToBeBought = getProductFromForm();
        this.inventory.buyProduct(productToBeBought);
        Toast.makeText(this, "Produto Comprado!", Toast.LENGTH_SHORT).show();
        this.goBackToMainInventoryScree();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        this.inventory = new Inventory(this);
        this.productBarcode = findViewById(R.id.buy_product_form_barcode);
        this.productName = findViewById(R.id.buy_product_form_name);
        this.productDescription= findViewById(R.id.buy_product_form_description);
        this.productSellPrice = findViewById(R.id.buy_product_form_sell_price);
        this.productSupplierPrice= findViewById(R.id.buy_product_form_supplier_price);
        this.productQuantity = findViewById(R.id.buy_product_form_quantity);
        this.productMeasuringUnit = findViewById(R.id.buy_product_form_measuring_unit);
        Button confirmPurchaseButton = findViewById(R.id.confirm_edit_prod);

        confirmPurchaseButton.setOnClickListener(it -> confirmProductPurchase());
    }
}