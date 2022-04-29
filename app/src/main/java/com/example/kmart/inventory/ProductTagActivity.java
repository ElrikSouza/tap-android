package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kmart.R;
import com.example.kmart.products.Product;
import com.example.kmart.products.ProductRepository;

import java.util.Locale;

public class ProductTagActivity extends AppCompatActivity {
    private ProductRepository productRepository;

    private Product getProduct() {
        Intent intent = this.getIntent();
        String barcode = intent.getExtras().getString("barcode");

        return this.productRepository.getProductByBarcode(barcode);
    }

    private void showProductData(Product product) {
        TextView tagName = findViewById(R.id.tag_name);
        TextView tagPrice = findViewById(R.id.tag_price);
        TextView tagBarcode = findViewById(R.id.tag_barcode);

        tagBarcode.setText(product.getBarcode());
        tagName.setText(product.getName());
        tagPrice.setText(String.format(Locale.getDefault(), "R$ %.2f", product.getSellPrice()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tag);
        this.productRepository = new ProductRepository(this);

        Product product = this.getProduct();
        this.showProductData(product);
    }
}