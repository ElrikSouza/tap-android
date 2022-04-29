package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.kmart.R;
import com.example.kmart.products.Product;
import com.example.kmart.products.ProductRepository;

public class EditProductActivity extends AppCompatActivity {
    private String barcode;
    private EditText nameField,  descriptionField, supplierPriceField, sellPriceField, quantityField, unitField;
    private ProductRepository productRepository;

    private void goBackToProductList() {
        Intent intent = new Intent(this, InventoryProductListActivity.class);
        startActivity(intent);
    }

    private Product getProductFromForm() {
        String name = nameField.getText().toString();
        String description = descriptionField.getText().toString();
        String measuringUnit = unitField.getText().toString();
        double supplierPrice = Double.parseDouble(supplierPriceField.getText().toString());
        double sellPrice = Double.parseDouble(sellPriceField.getText().toString());
        int quantity = Integer.parseInt(quantityField.getText().toString());

        return new Product(barcode, name, description, measuringUnit, supplierPrice, sellPrice, quantity);
    }

    private void submitForm() {
        Product productChanges = getProductFromForm();
        this.productRepository.updateProduct(productChanges);
        goBackToProductList();
    }

    private void setDefaultFormValues(Product product) {
        nameField.setText(product.getName());
        descriptionField.setText(product.getDescription());
        supplierPriceField.setText("" + product.getSupplierPrice());
        sellPriceField.setText("" + product.getSellPrice());
        quantityField.setText("" + product.getQuantityAvailable());
        unitField.setText("" + product.getMeasuringUnit());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        this.nameField = findViewById(R.id.edit_product_form_name);
        this.descriptionField = findViewById(R.id.edit_product_form_description);
        this.quantityField = findViewById(R.id.edit_product_form_quantity);
        this.supplierPriceField = findViewById(R.id.edit_product_form_supplier_price);
        this.sellPriceField = findViewById(R.id.edit_product_form_sell_price);
        this.unitField = findViewById(R.id.edit_product_form_measuring_unit);

        this.productRepository = new ProductRepository(this);

        Intent intent = getIntent();
        this.barcode = intent.getExtras().getString("barcode");
        Product product = this.productRepository.getProductByBarcode(this.barcode);
        setDefaultFormValues(product);

        Button submitBtn = findViewById(R.id.confirm_edit_prod);
        submitBtn.setOnClickListener(it -> submitForm());

    }
}