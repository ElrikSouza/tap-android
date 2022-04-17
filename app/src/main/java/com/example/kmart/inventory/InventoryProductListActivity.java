package com.example.kmart.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kmart.R;
import com.example.kmart.products.ProductAdapter;

public class InventoryProductListActivity extends AppCompatActivity {
    private RecyclerView productListView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_product_list);

        productListView = findViewById(R.id.product_list);
        productListView.setLayoutManager(new LinearLayoutManager(this));

        productAdapter = new ProductAdapter(this);
        productListView.setAdapter(productAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        productAdapter.refreshList();
        productAdapter.notifyDataSetChanged();
    }
}
